package commands;

import controller.UserController;

public class CreateUserCommand implements ICommand {
    UserController userController = new UserController();

    @Override
    public boolean matches(String command) {
        if(command.equals("CREATE_USER")) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String command) {
        String[] userDetails = command.split(" ");
        String userName = userDetails[1];
        String email = userDetails[2];
        userController.createUser(userName, email);
    }
}
