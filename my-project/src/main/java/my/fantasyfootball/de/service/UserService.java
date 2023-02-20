package my.fantasyfootball.de.service;

import my.fantasyfootball.de.model.user.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface UserService extends UserDetailsService {
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(UUID id);
    String signUpUser(User user);
    int enableUser(String email);
}
