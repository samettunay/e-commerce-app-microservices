package com.samet.ecommerce.payment;

import java.math.BigDecimal;

import com.samet.ecommerce.customer.CustomerResponse;
import com.samet.ecommerce.order.PaymentMethod;

public record PaymentRequest(
    BigDecimal amount,
    PaymentMethod paymentMethod,
    Integer orderId,
    String orderReference,
    CustomerResponse customer
) {

}
