package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand;
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse;
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper;
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCreatedMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreateCommandHandler {

    private final OrderCreateHelper orderCreateHelper;
    private final OrderCreatedMessagePublisher orderCreatedMessagePublisher;
    private final OrderDataMapper orderDataMapper;

    public OrderCreateCommandHandler(OrderCreateHelper orderCreateHelper,
                                     OrderCreatedMessagePublisher orderCreatedMessagePublisher,
                                     OrderDataMapper orderDataMapper) {
        this.orderCreateHelper = orderCreateHelper;
        this.orderCreatedMessagePublisher = orderCreatedMessagePublisher;
        this.orderDataMapper = orderDataMapper;
    }

    public CreateOrderResponse createOrder(CreateOrderCommand createOrderCommand){
        OrderCreatedEvent orderCreatedEvent = orderCreateHelper.persistOrder(createOrderCommand);
        orderCreatedMessagePublisher.publish(orderCreatedEvent);
        return orderDataMapper.orderToCreateOrderResponse(orderCreatedEvent.getOrder(), "Order Created Successfully");
    }
}
