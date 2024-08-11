package com.rs.trading.repository;

import com.rs.trading.modal.WatchList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WatchlistRepository extends JpaRepository<WatchList, Long> {
    WatchList findByUserId(Long userId);
}
