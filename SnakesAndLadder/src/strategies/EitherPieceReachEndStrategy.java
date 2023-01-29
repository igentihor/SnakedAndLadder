package strategies;

import models.Piece;

import java.util.List;

public class EitherPieceReachEndStrategy implements IWinningStrategy {
    @Override
    public boolean checkIfGameEnded(List<Piece> pieces, int boardSize) {
        for(int i=0; i<pieces.size(); i++) {
            if (pieces.get(i).getCell().getIndex() >= boardSize) {
                return true;
            }
        }
        return false;
    }
}
