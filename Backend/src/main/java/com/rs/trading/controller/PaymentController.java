package com.rs.trading.controller;

import com.rs.trading.domain.PaymentMethod;
import com.rs.trading.modal.PaymentOrder;
import com.rs.trading.modal.User;
import com.rs.trading.response.PaymentResponse;
import com.rs.trading.service.PaymentService;
import com.rs.trading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/api/payment/{paymentMethod}/amount/{amount}")
    public ResponseEntity<PaymentResponse> paymentHandler(@PathVariable PaymentMethod paymentMethod,
                                                          @PathVariable Long amount,
                                                          @RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);

        PaymentResponse paymentResponse;

        PaymentOrder order = paymentService.createOrder(user, amount, paymentMethod);

        if(paymentMethod.equals(PaymentMethod.RAZORPAY)){
            paymentResponse = paymentService.createRazorpayPaymentLink(user, amount);
        }else {
            paymentResponse = paymentService.createStripePaymentLink(user, amount, order.getId());
        }
        return  new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
    }
}
