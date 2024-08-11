package com.rs.trading.service;

import com.rs.trading.domain.VerificationType;
import com.rs.trading.modal.ForgotPasswordToken;
import com.rs.trading.modal.User;

public interface ForgotPasswordService {
    ForgotPasswordToken createToken(User user, String id, String otp, VerificationType verificationType,
                                    String sendTo);

    ForgotPasswordToken findById(String id);

    ForgotPasswordToken findByUser(Long userId);

    void deleteToken(ForgotPasswordToken token);

}
