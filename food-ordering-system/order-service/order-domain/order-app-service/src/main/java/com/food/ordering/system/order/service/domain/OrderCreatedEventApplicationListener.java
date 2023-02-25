package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent;
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCreatedMessagePublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Component
public class OrderCreatedEventApplicationListener {

    private final OrderCreatedMessagePublisher orderCreatedMessagePublisher;

    public OrderCreatedEventApplicationListener(OrderCreatedMessagePublisher orderCreatedMessagePublisher) {
        this.orderCreatedMessagePublisher = orderCreatedMessagePublisher;
    }

    /**
     * Process an event when a transaction is successfully committed
     * @param orderCreatedEvent event to process
     */
    @TransactionalEventListener
    void process(OrderCreatedEvent orderCreatedEvent){
        orderCreatedMessagePublisher.publish(orderCreatedEvent);
    }
}
