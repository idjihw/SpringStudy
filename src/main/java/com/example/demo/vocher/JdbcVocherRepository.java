package com.example.demo.vocher;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
@Profile("jdbc")
public class JdbcVocherRepository implements VocherRepository{
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
}
