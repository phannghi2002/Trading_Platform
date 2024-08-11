package com.rs.trading.service;

import com.rs.trading.domain.OrderType;
import com.rs.trading.modal.Coin;
import com.rs.trading.modal.Order;
import com.rs.trading.modal.OrderItem;
import com.rs.trading.modal.User;

import java.util.List;

public interface OrderService {
    Order createOrder(User user, OrderItem orderItem, OrderType orderType);

    Order getOrderById(Long orderId) throws Exception;

    List<Order> getAllOrdersOfUser(Long userId, OrderType orderType, String assetSymbol);

    Order processOrder(Coin coin, double quantity, OrderType orderType, User user) throws Exception;
}
