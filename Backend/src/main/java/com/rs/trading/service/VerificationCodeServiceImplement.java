package com.rs.trading.service;

import com.rs.trading.domain.VerificationType;
import com.rs.trading.modal.User;
import com.rs.trading.modal.VerificationCode;
import com.rs.trading.repository.VerificationCodeRepository;
import com.rs.trading.utils.otpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificationCodeServiceImplement implements VerificationCodeService {
    @Autowired
    private VerificationCodeRepository verificationCodeRepository;


    @Override
    public VerificationCode sendVerificationCode(User user, VerificationType verificationType) {
        VerificationCode verificationCode = new VerificationCode();
        verificationCode.setOtp(otpUtils.generateOTP());
        verificationCode.setVerificationType(verificationType);
        verificationCode.setUser(user);

        return verificationCodeRepository.save(verificationCode);
    }

    @Override
    public VerificationCode getVerificationCodeById(Long id) throws Exception {
        Optional<VerificationCode> verificationCode = verificationCodeRepository.findById(id);
        if (verificationCode.isPresent()) {
            return verificationCode.get();
        }
        throw new Exception("Verification code not found");
    }

    @Override
    public VerificationCode getVerificationCodeByUser(Long userId) {
        return verificationCodeRepository.findByUserId(userId);
    }

    @Override
    public void deleteVerificationCodeById(VerificationCode verificationCode) {
        verificationCodeRepository.delete(verificationCode);
    }
}
