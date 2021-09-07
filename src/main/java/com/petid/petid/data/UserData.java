package com.petid.petid.data;

import com.petid.petid.model.User;
import com.petid.petid.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserData {

    @Autowired
    private UserRepository userRepository;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        userRepository.save(new User("123", "stefan"));
        userRepository.save(new User("456","andrei"));
    }
}
