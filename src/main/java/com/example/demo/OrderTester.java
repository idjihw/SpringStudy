package com.example.demo;

import org.apache.commons.logging.Log;
import com.example.demo.Order.OrderItem;
import com.example.demo.Order.OrderProperties;
import com.example.demo.Order.OrderService;
import com.example.demo.configuration.Appconfiguration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderTester {
    private static final Logger logger = LoggerFactory.getLogger(OrderTester.class);
    public static void main(String[] args) {
        AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);
        var applicationContext = new AnnotationConfigApplicationContext(Appconfiguration.class);

        /*
        var environment = applicationContext.getEnvironment();
        var version = environment.getProperty("kdt.version");
        var description = environment.getProperty("kdt.version", List.class);
        System.out.println("version : " + version);
        System.out.println("version : " + description);
        */
        var orderProperties = applicationContext.getBean(OrderProperties.class);
        logger.info("version => {}", orderProperties.getVersion());

        var customerId = UUID.randomUUID();
        var orderService = applicationContext.getBean(OrderService.class);

        var order = orderService.createOrder(customerId, new ArrayList<OrderItem>(){{
            add(new OrderItem(UUID.randomUUID(), 100L, 1));
        }});
        Assert.isTrue(order.totalAmount() == 100L, MessageFormat.format("totalAmount {0} is not 100L", order.totalAmount()));

    }
}
