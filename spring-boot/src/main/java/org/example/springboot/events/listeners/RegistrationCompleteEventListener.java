package org.example.springboot.events.listeners;

import lombok.extern.slf4j.Slf4j;
import org.example.springboot.entity.User;
import org.example.springboot.events.RegistrationCompleteEvent;
import org.example.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //Create the User Verification Token with Url
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

        //Send Verification
        String url = event.getApplicationUrl() + "/api/v4/user/verifyRegistration?token=" + token;
        log.info("Generated link to verify account: {}", url);

        //Send Mail to user
    }
}
