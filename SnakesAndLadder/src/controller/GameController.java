package controller;

import models.Game;
import services.GameService;

import java.util.List;

public class GameController {
    GameService gameService = new GameService();

    public void startGame(int numPlayers, List<String> emailIDs, int boardSize, int numDices,
                          int maxDice, int numPieces, int winningStrategy) {
        Game game = gameService.createGame(numPlayers, emailIDs, boardSize,
                numDices, maxDice, numPieces, winningStrategy);
        gameService.startGame(game);
        return;
    }
}
