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
        //list
        List <Move> allowedMoves = new ArrayList<>();


        boolean black = this.getColour().equals(PlayerColour.BLACK);
        int moveBy = black ? 1 : -1;
        Coordinates to = new Coordinates(from.getRow()+moveBy, from.getCol());
        boolean squareAvailable = (board.get(to)==null);
        if (squareAvailable) allowedMoves.add(new Move(from,to));



        //implement first move
        boolean firstMove = ((black && from.getRow()==1)||(!black && from.getRow()==6))? true : false;
        if (firstMove){
            Coordinates to2 = new Coordinates(from.getRow()+moveBy*2, from.getCol());
            squareAvailable = (board.get(to2)==null);
            if (squareAvailable && allowedMoves.size()>0) allowedMoves.add(new Move(from,to2));
        }

        return allowedMoves;
    }
}
