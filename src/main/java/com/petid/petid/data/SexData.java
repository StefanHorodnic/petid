package com.petid.petid.data;

import com.petid.petid.model.Sex;
import com.petid.petid.repository.SexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SexData {

    @Autowired
    private SexRepository sexRepository;

    @EventListener
    public void appRead(ApplicationReadyEvent event) {
        sexRepository.save(new Sex("Femela"));
        sexRepository.save(new Sex("Mascul"));
    }
}
