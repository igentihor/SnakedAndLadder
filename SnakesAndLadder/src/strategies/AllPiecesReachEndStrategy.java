package strategies;

import models.Piece;

import java.util.List;

public class AllPiecesReachEndStrategy implements IWinningStrategy {
    @Override
    public boolean checkIfGameEnded(List<Piece> pieces, int boardSize) {
        boolean status = true;
        for(int i=0; i<pieces.size(); i++) {
            for(int j=0; j<pieces.size(); j++) {
                status = status && pieces.get(j).getCell().getIndex() >= boardSize;
            }
        }
        return status;
    }
}
