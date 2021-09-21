package com.petid.petid.data;

import com.petid.petid.model.User;
import com.petid.petid.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserData {

    @Autowired
    private UserService userService;

    @EventListener
    public void appReady(ApplicationReadyEvent event) {
        userService.save(new User("123", "stefan", "Ștefan Horodnic"));
        userService.save(new User("456","andrei", "Andrei Porgras"));
    }
}
