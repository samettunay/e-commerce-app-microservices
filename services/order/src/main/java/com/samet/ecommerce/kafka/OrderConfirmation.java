package com.samet.ecommerce.kafka;

import java.math.BigDecimal;
import java.util.List;

import com.samet.ecommerce.customer.CustomerResponse;
import com.samet.ecommerce.order.PaymentMethod;
import com.samet.ecommerce.product.PurchaseResponse;

public record OrderConfirmation(
    String reference,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    CustomerResponse customer,
    List<PurchaseResponse> products
) {

}
