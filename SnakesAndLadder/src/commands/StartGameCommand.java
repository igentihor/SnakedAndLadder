package commands;

import controller.GameController;

import java.util.ArrayList;
import java.util.List;

public class StartGameCommand implements ICommand {
    GameController gameController = new GameController();

    @Override
    public boolean matches(String command) {
        if(command.equals("START_GAME")) {
            return true;
        }
        return false;
    }

    @Override
    public void execute(String command) {
        String[] input = command.split(" ");
        List<String> emailIDs = new ArrayList<>();
        int index = 0;
        int numPlayers = Integer.parseInt(input[++index]);
        for (int i=0; i<numPlayers; i++) {
            emailIDs.add(input[++index]);
        }
        int boardSize = Integer.parseInt(input[++index]);
        int numDices = Integer.parseInt(input[++index]);
        int maxDice = Integer.parseInt(input[++index]);
        int numPieces = Integer.parseInt(input[++index]);
        int winningStrategy = Integer.parseInt(input[++index]);
        gameController.startGame(numPlayers, emailIDs, boardSize, numDices, maxDice, numPieces, winningStrategy);
    }
}
