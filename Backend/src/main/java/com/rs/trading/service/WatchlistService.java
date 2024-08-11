package com.rs.trading.service;

import com.rs.trading.modal.Coin;
import com.rs.trading.modal.User;
import com.rs.trading.modal.WatchList;

public interface WatchlistService {
    WatchList findUserWatchList(Long userId) throws Exception;

    WatchList createWatchList(User user);

    WatchList findById(Long id) throws Exception;

    Coin addItemToWatchlist(Coin coin, User user) throws Exception;
}
