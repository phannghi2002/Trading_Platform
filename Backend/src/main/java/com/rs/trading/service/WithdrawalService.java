package com.rs.trading.service;

import com.rs.trading.modal.User;
import com.rs.trading.modal.Withdrawal;


import java.util.List;

public interface WithdrawalService {
    Withdrawal requestyWithdrawal(Long amount, User user);

    Withdrawal proceedWithdrawal(Long withdrawalId, boolean accept) throws Exception;

    List<Withdrawal> getUsersWithdrawalHistory(User user);

    List<Withdrawal> getAllWithdrawalRequest();
}
