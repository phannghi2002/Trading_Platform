package com.rs.trading.modal;

import com.rs.trading.domain.VerificationType;
import lombok.Data;

@Data
public class TwoFactorAuth {
    private boolean isEnabled = false ;
    private VerificationType sendTo;
}
