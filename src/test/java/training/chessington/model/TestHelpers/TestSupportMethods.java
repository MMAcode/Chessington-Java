package training.chessington.model.TestHelpers;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.PlayerColour;
import training.chessington.model.pieces.*;

public class TestSupportMethods {

    public static void _placePawnBlack(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new Pawn(PlayerColour.BLACK));
    }
    public static void _placePawnWhite(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new Pawn(PlayerColour.WHITE));
    }
    public static void _placeKingBlack(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new King(PlayerColour.BLACK));
    }
    public static void _placeKingWhite(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new King(PlayerColour.WHITE));
    }
    public static void _placeQueenBlack(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new Queen(PlayerColour.BLACK));
    }
    public static void _placeQueenWhite(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new Queen(PlayerColour.WHITE));
    }
    public static void _placeKnightBlack(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new Knight(PlayerColour.BLACK));
    }
    public static void _placeKnightWhite(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new Knight(PlayerColour.WHITE));
    }
    public static void _placeBishopBlack(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new Bishop(PlayerColour.BLACK));
    }
    public static void _placeBishopWhite(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new Bishop(PlayerColour.WHITE));
    }
    public static void _placeRookBlack(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new Rook(PlayerColour.BLACK));
    }
    public static void _placeRookWhite(Board board, int row, int col) {
        board.placePiece(new Coordinates(row,col),new Rook(PlayerColour.WHITE));
    }

//
//    public void placePawnBlack(int row, int col) {
//        this.board[row][col] = new Pawn(PlayerColour.BLACK);
//    }
//    public void placePawnWhite(int row, int col) {
//        board[row][col] = new Pawn(PlayerColour.WHITE);
//    }
//    public void placeKingBlack(int row, int col) {
//        board[row][col] = new King(PlayerColour.BLACK);
//    }
//    public void placeKingWhite(int row, int col) {
//        board[row][col] = new King(PlayerColour.WHITE);
//    }
//    public void placeQueenBlack(int row, int col) {
//        board[row][col] = new Queen(PlayerColour.BLACK);
//    }
//    public void placeQueenWhite(int row, int col) {
//        board[row][col] = new Queen(PlayerColour.WHITE);
//    }
//    public void placeKnightBlack(int row, int col) {
//        board[row][col] = new Knight(PlayerColour.BLACK);
//    }
//    public void placeKnightWhite(int row, int col) {
//        board[row][col] = new Knight(PlayerColour.WHITE);
//    }
//    public void placeBishopBlack(int row, int col) {
//        board[row][col] = new Bishop(PlayerColour.BLACK);
//    }
//    public void placeBishopWhite(int row, int col) {
//        board[row][col] = new Bishop(PlayerColour.WHITE);
//    }
//    public void placeRookBlack(int row, int col) {
//        board[row][col] = new Rook(PlayerColour.BLACK);
//    }
//    public void placeRookWhite(int row, int col) {
//        board[row][col] = new Rook(PlayerColour.WHITE);
//    }
}
