package com.rs.trading.service;

import com.rs.trading.modal.PaymentDetails;
import com.rs.trading.modal.User;

public interface PaymentDetailsService {
    public PaymentDetails addPaymentDetails(String accountNumber, String accountHolderName,
                                            String ifsc, String bankName, User user);

    public PaymentDetails getUsersPaymentDetails(User user);
}
