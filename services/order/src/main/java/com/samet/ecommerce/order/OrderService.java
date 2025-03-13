package com.samet.ecommerce.order;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.samet.ecommerce.customer.CustomerClient;
import com.samet.ecommerce.exception.BusinessException;
import com.samet.ecommerce.orderline.OrderLineRequest;
import com.samet.ecommerce.orderline.OrderLineService;
import com.samet.ecommerce.product.ProductClient;
import com.samet.ecommerce.product.PurchaseRequest;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository repository;
    private final OrderLineService orderLineService;
    private final OrderMapper mapper;

    public Integer createOrder(OrderRequest request) {
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException(String.format("Cannot create order:: No Customer exists with the provided ID: %s", request.customerId())));
        
        this.productClient.purchaseProducts(request.products());

        var order = this.repository.save(mapper.toOrder(request));

        for(PurchaseRequest purchaseRequest : request.products()){
            orderLineService.saveOrderLine(
                new OrderLineRequest(
                   null,
                   order.getId(),
                   purchaseRequest.productId(),
                   purchaseRequest.quantity()
                )
            );
        }

        // TODO start payment process

        // TODO send notification
        
        return null;
    }

    public List<OrderResponse> findAllOrders() {
        return this.repository.findAll()
                .stream()
                .map(this.mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer id) {
        return this.repository.findById(id)
                .map(this.mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No order found with the provided ID: %d", id)));
    }
}
