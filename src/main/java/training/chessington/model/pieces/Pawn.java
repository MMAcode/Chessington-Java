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
        List <Move> allowedMoves = new ArrayList<>();

        boolean black = this.getColour().equals(PlayerColour.BLACK);
        int moveBy = black ? 1 : -1;
        Coordinates to = new Coordinates(from.getRow()+moveBy, from.getCol());
        boolean squareExists = (to.getRow()>=0 && to.getCol() >= 0)&&(to.getRow()<=7 && to.getCol() <= 7);
        boolean squareAvailable = squareExists ? (board.get(to)==null) : false;
        if (squareExists && squareAvailable) allowedMoves.add(new Move(from,to));

        //implement first (="double") move
        boolean isFirstMove = ((black && from.getRow()==1)||(!black && from.getRow()==6))? true : false;
        if (isFirstMove){
            Coordinates to2 = new Coordinates(from.getRow()+moveBy*2, from.getCol());
            squareAvailable = (board.get(to2)==null);
            if (squareAvailable && allowedMoves.size()>0) allowedMoves.add(new Move(from,to2));
        }

        return allowedMoves;
    }
}
