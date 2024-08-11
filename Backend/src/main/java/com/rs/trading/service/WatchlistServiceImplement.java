package com.rs.trading.service;

import com.rs.trading.modal.Coin;
import com.rs.trading.modal.User;
import com.rs.trading.modal.WatchList;
import com.rs.trading.repository.WatchlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WatchlistServiceImplement implements WatchlistService{
    @Autowired
    private WatchlistRepository watchlistRepository;

    @Override
    public WatchList findUserWatchList(Long userId) throws Exception {
        WatchList watchList = watchlistRepository.findByUserId(userId);
        if(watchList == null){
            throw new Exception("Watchlist not found");
        }
        return watchList;
    }

    @Override
    public WatchList createWatchList(User user) {
        WatchList watchList = new WatchList();
        watchList.setUser(user);

        return watchlistRepository.save(watchList);
    }

    @Override
    public WatchList findById(Long id) throws Exception {
        Optional<WatchList> watchListOptional = watchlistRepository.findById(id);
        if(watchListOptional.isEmpty()){
            throw new Exception("Watchlist not found");
        }
        return watchListOptional.get();
    }

    @Override
    public Coin addItemToWatchlist(Coin coin, User user) throws Exception {
        WatchList watchList = findUserWatchList(user.getId());

        if(watchList.getCoins().contains(coin)){
            watchList.getCoins().remove(coin);
        }else {
            watchList.getCoins().add(coin);
        }
        watchlistRepository.save(watchList);
        return coin;
    }
}
