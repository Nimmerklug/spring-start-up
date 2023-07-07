package org.example.springboot.services;


import org.example.springboot.entity.User;
import org.example.springboot.entity.VerificationToken;
import org.example.springboot.models.UserModel;

import java.util.Optional;

public interface UserService {
    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    boolean validateVerificationToken(String token);

    VerificationToken generateNewVeficationToken(String token);

    User findUserByEmail(String email);

    void createPasswordResetTokenForUser(User user, String token);

    boolean validatePasswordResetToken(String token);

    Optional<User> getUserByPasswordResetToken(String token);

    void chanePassword(User user, String newPassword);

    boolean isOldPassswordvalid(User user, String oldPassword);
}
