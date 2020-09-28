package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends LinearMover {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        Moves allowedMoves = new Moves();

        allowedMoves.addIfExists(getMovesInDirection(board,from,"UpRight"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"DownRight"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"UpLeft"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"DownLeft"));
        return allowedMoves.get();
    }
}
