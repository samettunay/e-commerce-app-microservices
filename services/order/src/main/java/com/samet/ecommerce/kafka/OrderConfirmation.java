package com.samet.ecommerce.kafka;

import com.samet.ecommerce.customer.CustomerResponse;
import com.samet.ecommerce.order.PaymentMethod;
import com.samet.ecommerce.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products

) {
}
