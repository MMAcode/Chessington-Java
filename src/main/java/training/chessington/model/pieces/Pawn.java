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

        boolean thisPieceIsBlack = this.getColour().equals(PlayerColour.BLACK);
        int moveBy = thisPieceIsBlack ? 1 : -1;
        Coordinates to = adjustSingleCoordinates(from,moveBy,0);
        boolean squareAvailable = squareExists(to) ? (board.get(to)==null) : false;
        if (squareAvailable) allowedMoves.add(new Move(from,to));

        //implement first (="double") move
        boolean isFirstMove = ((thisPieceIsBlack && from.getRow()==1)||(!thisPieceIsBlack && from.getRow()==6))? true : false;
        if (isFirstMove){
            Coordinates to2 = adjustSingleCoordinates(from,moveBy*2,0);
            squareAvailable = (board.get(to2)==null);
            if (squareAvailable && allowedMoves.size()>0) allowedMoves.add(new Move(from,to2));
        }

        //sort enemy's pieces
        Coordinates myPosition = from;
        Coordinates enemy1PossibleCoordinates = thisPieceIsBlack ? adjustSingleCoordinates(from,1,1) : adjustSingleCoordinates(from,-1,1);
        Coordinates enemy2PossibleCoordinates = thisPieceIsBlack ? adjustSingleCoordinates(from,1,-1) : adjustSingleCoordinates(from,-1,-1);

        boolean enemyPiece1Exists = false;
        if (squareExists(enemy1PossibleCoordinates)){
            Piece enemyPiece = board.get(enemy1PossibleCoordinates);
            if (enemyPiece!=null) {
                if (enemyPiece.getColour()!=this.getColour()) enemyPiece1Exists = true;
            }
        }
        boolean enemyPiece2Exists = false;
        if (squareExists(enemy2PossibleCoordinates)){
            Piece enemyPiece = board.get(enemy2PossibleCoordinates);
            if (enemyPiece!=null) {
                if (enemyPiece.getColour()!=this.getColour()) enemyPiece2Exists = true;
            }
        }

        if (enemyPiece1Exists) allowedMoves.add(new Move(from,enemy1PossibleCoordinates));
        if (enemyPiece2Exists) allowedMoves.add(new Move(from,enemy2PossibleCoordinates));


        return allowedMoves;
    }

    private boolean squareExists (Coordinates c){
        return (c.getRow()>=0 && c.getCol() >= 0)&&(c.getRow()<=7 && c.getCol() <= 7);
    }
    private Coordinates adjustSingleCoordinates (Coordinates c,int row, int col){
        return new Coordinates(c.getRow()+row, c.getCol()+col);
    }


}
