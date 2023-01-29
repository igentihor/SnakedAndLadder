package models;

import lombok.Getter;
import strategies.IWinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {
    private int numPieces;
    private Board board;
    private List<Dice> dices = new ArrayList<>();
    private List<Player> players = new ArrayList<>();
    private IWinningStrategy winningStrategy;

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private Game game;

        private Builder() {
            game = new Game();
        }

        public Builder setNumPieces(int numPieces) {
            game.numPieces = numPieces;
            return this;
        }

        public Builder setBoard(int size) {
            game.board = new Board(size);
            return this;
        }

        public Builder setDices(int numDices, int maxNumber) {
            for(int i=0; i<numDices; i++) {
                game.dices.add(new Dice(maxNumber));
            }
            return this;
        }

        public Builder setPlayers(int numPlayers, List<User> users) {
            for(int i=0; i<numPlayers; i++) {
                game.players.add(new HumanPlayer(users.get(i), game.numPieces, i));
            }
            return this;
        }
        public Builder setWinningStrategy(IWinningStrategy winningStrategy) {
            game.winningStrategy = winningStrategy;
            return this;
        }

        public Game build() {
            return game;
        }
    }
}
