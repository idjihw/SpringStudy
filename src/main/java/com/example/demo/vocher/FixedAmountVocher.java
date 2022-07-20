package com.example.demo.vocher;

import java.util.UUID;

public class FixedAmountVocher implements Vocher {

    private final UUID vocherId;
    private final long amount;


    public FixedAmountVocher(UUID vocherId, long amount) {
        this.vocherId = vocherId;
        this.amount = amount;
    }

    public UUID getVocherId() {
        return vocherId;
    }

    public long discount(long beforeDiscount){
        return beforeDiscount - amount;
    }


}
