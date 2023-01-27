package models;

import lombok.Getter;
import repositories.UserRepository;

@Getter
public class HumanPlayer extends Player {
    private User user;
    UserRepository userRepository = new UserRepository();

    HumanPlayer(String emailId, int numPieces, int color) {
        super(numPieces, color);
        this.user = userRepository.getUser(emailId);
    }
}
