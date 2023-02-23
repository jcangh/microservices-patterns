package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.valueobject.OrderId;

import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        //Product product = new Product()
        Order order = Order.builder()
                .orderId(new OrderId(UUID.fromString("juan")))
                .build();
        OrderItem orderItem = OrderItem.builder()
                .quantity(1)
                .build();
    }
}
