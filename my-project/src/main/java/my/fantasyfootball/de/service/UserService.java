package my.fantasyfootball.de.service;

import my.fantasyfootball.de.model.User;

import java.util.UUID;

public interface UserService {
    void addUser(User user);
    void updateUser(User user);

    void deleteUser(UUID id);
}
