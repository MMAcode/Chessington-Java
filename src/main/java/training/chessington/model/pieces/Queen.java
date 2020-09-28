package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.List;

public class Queen extends LinearMover {
    public Queen(PlayerColour colour) {
        super(PieceType.QUEEN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        Moves allowedMoves = new Moves();

        allowedMoves.addIfExists(getMovesInDirection(board,from,"Up"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"Down"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"Right"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"Left"));

        allowedMoves.addIfExists(getMovesInDirection(board,from,"UpRight"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"DownRight"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"UpLeft"));
        allowedMoves.addIfExists(getMovesInDirection(board,from,"DownLeft"));

        return allowedMoves.get();
    }
}
