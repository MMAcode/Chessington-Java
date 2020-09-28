package training.chessington.model.pieces;

import training.chessington.model.*;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {
        Moves allowedMoves = new Moves();
        allowedMoves.addIfExists(getBasicMove(from,board));

        boolean pawnCanDoOneStep = allowedMoves.get().size()>0;
        if(pawnCanDoOneStep) allowedMoves.addIfExists(getDoubleMoveIfApplicable(from,board));

        allowedMoves.addIfExists(getDiagonalCapturingMoves(from,board));

        return allowedMoves.get();
    }
    private List<Move> getBasicMove(Coordinates from, Board board){
        List<Move> localAllowedMoves = new ArrayList<>();
        int moveBy = this.isBlack() ? 1 : -1;
        Coordinates to = from.plus(moveBy,0);
        boolean squareAvailable = to.existOnTheBoard() ? (board.get(to)==null) : false;
        if (squareAvailable) localAllowedMoves.add(new Move(from,to));
        return localAllowedMoves;
    }
    private List<Move> getDoubleMoveIfApplicable(Coordinates from, Board board) {
        List <Move> allowedMoves = new ArrayList<>();
        int moveBy = this.isBlack() ? 2 : -2;
        boolean isFirstMove = ((this.isBlack() && from.getRow() == 1) || (!this.isBlack() && from.getRow() == 6)) ? true : false;
        if (isFirstMove) {
            Coordinates to2 = from.plus(moveBy, 0);
            boolean squareAvailable = (board.get(to2) == null);
            if (squareAvailable) allowedMoves.add(new Move(from, to2));
        }
        return allowedMoves;
    }
    private List<Move> getDiagonalCapturingMoves(Coordinates from, Board board){
        List <Move> allowedMoves = new ArrayList<>();
        Coordinates potentialPositionOfRightEnemy = this.isBlack() ? from.plus(1,1) : from.plus(-1,1);
        Coordinates potentialPositionOfLeftEnemy = this.isBlack() ? from.plus(1,-1) : from.plus(-1,-1);
        boolean rightEnemyExists = false;
        if (potentialPositionOfRightEnemy.existOnTheBoard()){
            Piece enemyPiece = board.get(potentialPositionOfRightEnemy);
            if (enemyPiece!=null) {
                if (enemyPiece.getColour()!=this.getColour()) rightEnemyExists = true;
            }
        }
        boolean leftEnemyExists = false;
        if (potentialPositionOfLeftEnemy.existOnTheBoard()){
            Piece enemyPiece = board.get(potentialPositionOfLeftEnemy);
            if (enemyPiece!=null) {
                if (enemyPiece.getColour()!=this.getColour()) leftEnemyExists = true;
            }
        }

        if (rightEnemyExists) allowedMoves.add(new Move(from,potentialPositionOfRightEnemy));
        if (leftEnemyExists) allowedMoves.add(new Move(from,potentialPositionOfLeftEnemy));

        return allowedMoves;
    }


}
