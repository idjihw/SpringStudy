package com.example.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
class A{
    private final B b;

    A(B b){
        this.b = b;
    }
}

class B {
    private final A a;

    B(A a){
        this.a = a;
    }
}

// B->A 참조, A->B 참조
@Configuration
class CircularConfig{
    @Bean
    public A a(B b){
        return new A(b);
    }

    @Bean
    public B b(A a){
        return new B(a);
    }
}

 */

public class CircularDepTester {
    public static void main(String[] args) {
        //new AnnotationConfigApplicationContext(CircularConfig.class);
    }


}
