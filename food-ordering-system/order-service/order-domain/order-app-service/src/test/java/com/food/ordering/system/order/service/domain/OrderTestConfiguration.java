package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCancelledMessagePublisher;
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCreatedMessagePublisher;
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.restaurant.OrderPaidMessagePublisher;
import com.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository;
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository;
import com.food.ordering.system.order.service.domain.ports.output.repository.RestaurantRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.mockito.Mockito.mock;

@SpringBootApplication(scanBasePackages = "com.food.ordering.system")
public class OrderTestConfiguration {

    @Bean
    public OrderCreatedMessagePublisher orderCreatedMessagePublisher(){
        return mock(OrderCreatedMessagePublisher.class);
    }

    @Bean
    public OrderCancelledMessagePublisher orderCancelledMessagePublisher(){
        return mock(OrderCancelledMessagePublisher.class);
    }

    @Bean
    public OrderPaidMessagePublisher orderPaidMessagePublisher(){
        return mock(OrderPaidMessagePublisher.class);
    }

    @Bean
    public OrderRepository orderRepository(){
        return mock(OrderRepository.class);
    }

    @Bean
    public CustomerRepository customerRepository(){
        return mock(CustomerRepository.class);
    }

    @Bean
    public RestaurantRepository restaurantRepository(){
        return mock(RestaurantRepository.class);
    }

    @Bean
    public OrderDomainService orderDomainService(){
        return new OrderDomainServiceImpl();
    }
}
