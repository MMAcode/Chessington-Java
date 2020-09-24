package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        boolean black = this.getColour().equals(PlayerColour.BLACK);
        int moveBy = black ? 1 : -1;
        Coordinates to = new Coordinates(from.getRow()+moveBy, from.getCol());

        Move allowedMove = new Move(from,to);

        //list
        List <Move> allowedMoves = new ArrayList<>();
        allowedMoves.add(allowedMove);


        //implement first move
        boolean firstMove = ((black && from.getRow()==1)||(!black && from.getRow()==6))? true : false;
        if (firstMove){
            allowedMoves.add(new Move(from, new Coordinates(from.getRow()+moveBy*2, from.getCol())));
        }

        return allowedMoves;
    }
}
