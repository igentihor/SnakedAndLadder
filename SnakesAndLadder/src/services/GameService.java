package services;

import exceptions.InvalidCommandException;
import models.*;
import repositories.UserRepository;
import strategies.AllPiecesReachEndStrategy;
import strategies.EitherPieceReachEndStrategy;
import strategies.IWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameService {
    UserRepository userRepository = new UserRepository();

    public Game createGame(int numPlayers, List<String> emailIDs, int boardSize, int numDices,
                           int maxDice, int numPieces, int winningStrategy) {
        IWinningStrategy iWinningStrategy;
        switch (winningStrategy) {
            case 0:
                iWinningStrategy = new EitherPieceReachEndStrategy();
                break;
            case 1:
                iWinningStrategy = new AllPiecesReachEndStrategy();
                break;
            default:
                throw new InvalidCommandException();
        }
        List<User> users = new ArrayList<>();
        for (int i=0; i<numPlayers; i++) {
            users.add(userRepository.getUser(emailIDs.get(i)));
        }
        Game game = Game.getBuilder()
                .setNumPieces(numPieces)
                .setBoard(boardSize)
                .setDices(numDices, maxDice)
                .setPlayers(numPlayers, users)
                .setWinningStrategy(iWinningStrategy)
                .build();
        return game;
    }

    public void startGame(Game game) {
        int numPlayers = game.getPlayers().size();
        while(true) {
            for(int i=0; i<numPlayers; i++) {
                HumanPlayer player = (HumanPlayer) game.getPlayers().get(i);
                System.out.println(player.getUser().getName() + "'s turn");
                Random random = new Random();
                int diceRollResult = 0;
                for(int j=0; j<game.getDices().size(); j++) {
                    diceRollResult += game.getDices().get(j).roll();
                }
                int pieceNumber = random.nextInt(game.getNumPieces());
                player.getPieces().get(pieceNumber).movePiece(game.getBoard(), diceRollResult);
                if(game.getWinningStrategy().checkIfGameEnded(player.getPieces(), game.getBoard().getSize()-1)) {
                    System.out.println(player.getUser().getName() + " won");
                    return;
                }
            }
        }
    }
}
