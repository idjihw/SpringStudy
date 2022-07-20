package com.example.demo.vocher;

import java.util.UUID;

public interface Vocher {
    UUID getVocherId();

    long discount(long beforeDiscount);

}
