package com.example.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;
import java.util.UUID;

@Configuration
@ComponentScan(basePackages = {"com.example.demo.Order", "com.example.demo.vocher", "com.example.demo.configuration"})
public class Appconfiguration {

    @Bean(initMethod = "init")
    public BeanOne beanOne(){
        return new BeanOne();
    }



    /*
    @Bean
    public VocherRepository vocherRepository(){
        return new VocherRepository() {
            @Override
            public Optional<Vocher> findById(UUID vocherId) {
                return Optional.empty();
            }
        };
    }
    @Bean
    public OrderRepository orderRepository(){
        return new OrderRepository(){
            @Override
            public Order insert(Order order) {

            }
        };
    }
    @Bean
    public VocherService vocherService(VocherRepository vocherRepository){
        return new VocherService(vocherRepository);
    }
    @Bean
    public OrderService orderService(VocherService vocherService, OrderRepository orderRepository){
        return new OrderService(vocherService, orderRepository);
    }

     */
}

class BeanOne implements InitializingBean {
    public void init(){
        System.out.println("[BeanOne] init called..");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet called..");
    }
}
