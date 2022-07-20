package com.example.demo.vocher;

import java.util.Optional;
import java.util.UUID;

public interface VocherRepository {
    Optional<Vocher> findById(UUID vocherId);
    Vocher insert(Vocher vocher);
}
