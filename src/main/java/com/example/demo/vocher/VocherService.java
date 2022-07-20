package com.example.demo.vocher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.UUID;
@Service
public class VocherService {

    @Autowired
    private VocherRepository vocherRepository;

    // public VocherService(VocherRepository vocherRepository) {
      //  this.vocherRepository = vocherRepository;
    //}

    public Vocher getVocher(UUID vocherId){
        return vocherRepository
                .findById(vocherId)
                .orElseThrow(() -> new RuntimeException(MessageFormat.format("Can not find a vocher for {0}", vocherId)));
    }
    public void useVocher(Vocher vocher) {
    }
}
