package com.samet.ecommerce.payment;

import com.samet.ecommerce.customer.CustomerResponse;
import com.samet.ecommerce.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {
}
