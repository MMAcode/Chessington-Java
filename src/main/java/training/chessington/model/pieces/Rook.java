package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class Rook extends LinearMover {
    public Rook(PlayerColour colour) {
        super(PieceType.ROOK, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        Moves allowedMoves = new Moves();

        allowedMoves.addIfExists(getMovesInDirection(board,from,"Up"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"Down"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"Right"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"Left"));
        //allowedMoves.get().forEach(System.out::println);
        return allowedMoves.get();
    }



}
