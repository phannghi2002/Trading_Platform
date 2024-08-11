package com.rs.trading.service;

import com.razorpay.RazorpayException;
import com.rs.trading.domain.PaymentMethod;
import com.rs.trading.modal.PaymentOrder;
import com.rs.trading.modal.User;
import com.rs.trading.response.PaymentResponse;
import com.stripe.exception.StripeException;

public interface PaymentService {
    PaymentOrder createOrder(User user, Long amount,PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    Boolean ProceedPaymentOrder(PaymentOrder paymentOrder,String paymentId) throws RazorpayException;

    PaymentResponse createRazorpayPaymentLink(User user, Long amount) throws RazorpayException;

    PaymentResponse createStripePaymentLink(User user, Long amount, Long orderId) throws StripeException;;

}
