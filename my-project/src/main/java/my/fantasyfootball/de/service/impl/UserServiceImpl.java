package my.fantasyfootball.de.service.impl;

import my.fantasyfootball.de.model.User;
import my.fantasyfootball.de.repository.UserRepository;
import my.fantasyfootball.de.service.UserService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(UUID id) {
        userRepository.deleteById(id);
    }
}
