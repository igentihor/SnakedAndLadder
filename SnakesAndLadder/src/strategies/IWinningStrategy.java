package strategies;

import models.Piece;

import java.util.List;

public interface IWinningStrategy {
    boolean checkIfGameEnded(List<Piece> pieces, int boardSize);
}
