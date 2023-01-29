package repositories;

import models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> users = new ArrayList<>();

    public void printUsers() {
        users.forEach(user -> System.out.println(user));
    }

    public void addUser(User user) {
        users.add(user);
        printUsers();
    }

    public User getUser(String emailId) {
        for(User user : users) {
            if (user.getEmail().equals(emailId))
                return user;
        }
        return null;
    }
}
