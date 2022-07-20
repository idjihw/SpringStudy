package com.example.demo.vocher;

import java.util.UUID;

public class PercenDiscountVocher implements Vocher{
    private final UUID vocherId;
    private final long percent;


    public PercenDiscountVocher(UUID vocherId, long percent) {
        this.vocherId = vocherId;
        this.percent = percent;
    }

    public UUID getVocherId() {
        return vocherId;
    }

    public long discount(long beforeDiscount){
        return beforeDiscount * (percent / 100);
    }
}
