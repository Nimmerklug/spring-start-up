package org.example.springboot.controllers;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.springboot.entity.User;
import org.example.springboot.entity.VerificationToken;
import org.example.springboot.events.RegistrationCompleteEvent;
import org.example.springboot.models.PasswordModel;
import org.example.springboot.models.UserModel;
import org.example.springboot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("api/v4/user")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @PostMapping("register")
    public User registerUser(@RequestBody UserModel UserModel, final HttpServletRequest servletRequest) {
        User user = userService.registerUser(UserModel);

        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(servletRequest)));

        return user;
    }

    @PostMapping("resetPassword")
    public String resetPassword(@RequestBody PasswordModel passwordModel, HttpServletRequest servletRequest) {
        User user = userService.findUserByEmail(passwordModel.getEmail());
        if (user == null) return "Invalid Email";

        String token = UUID.randomUUID().toString();
        userService.createPasswordResetTokenForUser(user, token);
        String url = passwordResetTokenRequest(user, token, applicationUrl(servletRequest));


        return url;
    }

    @PostMapping("changePassword")
    public String changePassword(@RequestBody PasswordModel passwordModel, HttpServletRequest servletRequest) {
        User user = userService.findUserByEmail(passwordModel.getEmail());
        if (user == null) return "Invalid Email";

        if (!userService.isOldPassswordvalid(user, passwordModel.getOldPassword())) return "Invalid Old Password";

        //save Password
        userService.chanePassword(user, passwordModel.getNewPassword());

        return "Successfully Changed Password";
    }

    @PostMapping("savePassword")
    public String savePassword(@RequestParam("token") String token, @RequestBody PasswordModel passwordModel) {
        boolean result = userService.validatePasswordResetToken(token);
        if (result) {
            return "User Reset Password Successfully";
        }

        Optional<User> optionalUser = userService.getUserByPasswordResetToken(token);

        if (optionalUser.isEmpty()) return "User Reset Password Successfully";

        userService.chanePassword(optionalUser.get(), passwordModel.getNewPassword());

        return "Invalid Token";
    }

    private String passwordResetTokenRequest(User user, String token, String applicationUrl) {
        String url = applicationUrl + "/api/v4/user/savePassword?token=" + token;
        log.info("Generated link to reset password: {}", url);
        return url;
    }

    @GetMapping("verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token) {
        boolean result = userService.validateVerificationToken(token);
        if (result) {
            return "User Verified Successfully";
        }

        return "Bad User";
    }

    @GetMapping("resendVerifyToken")
    public String resendVerifyToken(@RequestParam("token") String token, HttpServletRequest servletRequest) {
        VerificationToken verificationToken = userService.generateNewVeficationToken(token);
        if (verificationToken == null) return "Invalid Token";
        User user = verificationToken.getUser();
        resendVerifyTokenRequest(user, verificationToken, applicationUrl(servletRequest));
        return "Link was send again";
    }

    private void resendVerifyTokenRequest(User user, VerificationToken verificationToken, String applicationUrl) {
        String url = applicationUrl + "/api/v4/user/verifyRegistration?token=" + verificationToken.getToken();
        log.info("Generated link to verify account: {}", url);
    }

    private String applicationUrl(HttpServletRequest servletRequest) {
        return "http://" + servletRequest.getServerName() + ":" + servletRequest.getServerPort() + servletRequest.getContextPath();
    }
}
