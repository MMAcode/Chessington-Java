package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public abstract class LinearMover extends AbstractPiece {
    public LinearMover(PieceType type, PlayerColour colour) {
        super(type, colour);
    }

    /**
     * @param direction Right Left Up Down; and doubles eg: UpRight, RightUp etc
     */
    public List<Move> getMovesInDirection(Board board, Coordinates from, String direction){
        List<Move> movesToAdd= new ArrayList<>();
        Coordinates squareToCheckNow = from.getNextSquareInDirection(direction);
        do {
            if (squareToCheckNow.existOnTheBoard()){
                Piece pieceOnSquareToCheck = board.get(squareToCheckNow);
                if (pieceOnSquareToCheck==null){
                    movesToAdd.add(new Move(from,squareToCheckNow));
                    squareToCheckNow = squareToCheckNow.getNextSquareInDirection(direction);
                }else {
                    boolean squareToCheckIsOccupiedByEnemy = !this.getColour().equals(pieceOnSquareToCheck.getColour());
                    if (squareToCheckIsOccupiedByEnemy) movesToAdd.add(new Move(from,squareToCheckNow));
                    break;
                }
            } else break;
        } while (true);
        return movesToAdd;
    }
}
