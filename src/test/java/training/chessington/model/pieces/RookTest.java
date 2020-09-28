package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
//Miro imported:
import static training.chessington.model.TestHelpers.TestSupportMethods.*;

public class RookTest {
    @Test
    public void whiteRookCanMoveUpOneSquare() {
        //Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates c55 = new Coordinates(5, 5);
        board.placePiece(c55, rook);

        //Act
        List<Move> moves = rook.getAllowedMoves(c55, board);

        //Assert
        assertThat(moves).contains(new Move(c55, c55.plus(-1, 0)));
    }

    @Test
    public void blackRookCanMoveDownOneSquare() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.BLACK);
        Coordinates c55 = new Coordinates(5, 5);
        board.placePiece(c55, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(c55, board);

        // Assert
        assertThat(moves).contains(new Move(c55, c55.plus(1, 0)));
    }

    @Test
    public void whiteRookCanMoveRight7Squares() {
        // Arrange
        Board board = Board.empty();
        Piece rook = new Rook(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(0, 0);
        board.placePiece(coords, rook);

        // Act
        List<Move> moves = rook.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, new Coordinates(7, 0)));
    }

    @Test
    public void blackRookCannotMoveIfInCornerAndBlackPiecesAround() {
        // Arrange
        Board board = Board.empty();

        Piece blackRook = new Rook(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(0, 0);
        board.placePiece(blackCoords, blackRook);


        _placeRookBlack(board, 1, 0);
        _placeRookBlack(board, 0, 1);

        // Act
        List<Move> blackMoves = blackRook.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(blackMoves).isEmpty();
    }

    @Test
    public void blackRookCanDo2MovesOnlyIfInCornerAndWhitePiecesAround() {
        // Arrange
        Board board = Board.empty();

        Piece blackRook = new Rook(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(0, 0);
        board.placePiece(blackCoords, blackRook);

        _placePawnWhite(board, 1, 0);
        _placePawnWhite(board, 0, 1);

        // Act
        List<Move> blackMoves = blackRook.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(blackMoves.size()).isEqualTo(2);
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(1, 0)));
        assertThat(blackMoves).contains(new Move(blackCoords, blackCoords.plus(0, 1)));
    }

    @Test
    public void rooksCantGoOffTheBoard() {
        // Arrange
        Board board = Board.empty();

        Piece blackRook = new Rook(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(0, 0);
        board.placePiece(blackCoords, blackRook);

        Piece whiteRook = new Rook(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(3, 3);
        board.placePiece(whiteCoords, whiteRook);

        // Act
        List<Move> blackMoves = blackRook.getAllowedMoves(blackCoords, board);
        List<Move> whiteMoves = blackRook.getAllowedMoves(blackCoords, board);

        // Assert
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, new Coordinates(-1, 0)));
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, new Coordinates(0, -1)));
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, new Coordinates(8, 0)));
        assertThat(blackMoves).doesNotContain(new Move(blackCoords, new Coordinates(0, 8)));

        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, new Coordinates(3, -1)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, new Coordinates(3, 8)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, new Coordinates(-1, 3)));
        assertThat(whiteMoves).doesNotContain(new Move(whiteCoords, new Coordinates(8, 3)));
    }

    @Test
    public void rooksCanCaptureHorizontally() {
        // Arrange
        Board board = Board.empty();

        Piece blackRook = new Rook(PlayerColour.BLACK);
        Coordinates blackCoords = new Coordinates(1, 1);
        board.placePiece(blackCoords, blackRook);

        Piece whiteRook = new Rook(PlayerColour.WHITE);
        Coordinates whiteCoords = new Coordinates(1, 3);
        board.placePiece(whiteCoords, whiteRook);

        // Act
        List<Move> blackMoves = blackRook.getAllowedMoves(blackCoords, board);
        List<Move> whiteMoves = whiteRook.getAllowedMoves(whiteCoords, board);

        // Assert
        assertThat(blackMoves).contains(new Move(blackCoords, new Coordinates(1, 3)));

        assertThat(whiteMoves).contains(new Move(whiteCoords, new Coordinates(1, 1)));
    }

}
