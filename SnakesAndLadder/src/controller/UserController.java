package controller;

import services.UserService;

public class UserController {
    private UserService userService = new UserService();

    public void createUser(String name, String email) {
        userService.createUser(name, email);
    }
}
