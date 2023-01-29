package services;

import models.User;
import repositories.UserRepository;

import java.util.UUID;

public class UserService {
    private UserRepository userRepository = new UserRepository();

    public User createUser(String name, String email) {
        UUID uuid = UUID.randomUUID();
        User user = new User(uuid, name, email);
        userRepository.addUser(new User(uuid, name, email));
        return user;
    }
}
