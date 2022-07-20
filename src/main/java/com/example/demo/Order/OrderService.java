package com.example.demo.Order;

import com.example.demo.vocher.VocherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class OrderService {
    private final VocherService vocherService;
    private final OrderRepository orderRepository;

    public OrderService(VocherService vocherService, OrderRepository orderRepository) {
        this.vocherService = vocherService;
        this.orderRepository = orderRepository;
    }

    public Order createOrder(UUID customerId, List<OrderItem> orderItems){
        var order =  new Order(UUID.randomUUID(), customerId, orderItems);
        return orderRepository.insert(order);
    }

    public Order createOrder(UUID customerId, List<OrderItem> orderItems, UUID vocherId){
        var vocher = vocherService.getVocher(vocherId);
        var order =  new Order(UUID.randomUUID(), customerId, orderItems, vocher);
        orderRepository.insert(order);
        vocherService.useVocher(vocher);
        return order;
    }
}
