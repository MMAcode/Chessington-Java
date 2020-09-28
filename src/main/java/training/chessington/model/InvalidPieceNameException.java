package training.chessington.model;

public class InvalidPieceNameException extends RuntimeException{
    public InvalidPieceNameException(String name){
        super("Chess piece name '" + name +"' doesn't exist.");
    }
}
