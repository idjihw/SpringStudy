package com.example.demo.vocher;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Primary
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MemoryVocherRepository implements VocherRepository, InitializingBean, DisposableBean {

    private final Map<UUID, Vocher> storage = new ConcurrentHashMap<>();
    @Override
    public Optional<Vocher> findById(UUID vocherId) {
        return Optional.ofNullable(storage.get(vocherId));
    }

    @Override
    public Vocher insert(Vocher vocher) {
        storage.put(vocher.getVocherId(), vocher);
        return vocher;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct called..");
    }
    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy called..");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet called..");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy called..");
    }
}
