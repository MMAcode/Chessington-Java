package training.chessington.model;

import training.chessington.model.pieces.*;

public class Board {

    //original
    private Piece[][] board = new Piece[8][8];
    private Board() { }

    public static Board forNewGame() {
        Board board = new Board();
        board.setBackRow(0, PlayerColour.BLACK);
        board.setBackRow(7, PlayerColour.WHITE);

        for (int col = 0; col < 8; col++) {
            board.board[1][col] = new Pawn(PlayerColour.BLACK);
            board.board[6][col] = new Pawn(PlayerColour.WHITE);
        }

        return board;
    }

    public static Board empty() {
        return new Board();
    }

    private void setBackRow(int rowIndex, PlayerColour colour) {
        board[rowIndex][0] = new Rook(colour);
        board[rowIndex][1] = new Knight(colour);
        board[rowIndex][2] = new Bishop(colour);
        board[rowIndex][3] = new Queen(colour);
        board[rowIndex][4] = new King(colour);
        board[rowIndex][5] = new Bishop(colour);
        board[rowIndex][6] = new Knight(colour);
        board[rowIndex][7] = new Rook(colour);
    }

    public Piece get(Coordinates coords) {
        return board[coords.getRow()][coords.getCol()];
    }

    public void move(Coordinates from, Coordinates to) {
        board[to.getRow()][to.getCol()] = board[from.getRow()][from.getCol()];
        board[from.getRow()][from.getCol()] = null;
    }

    public void placePiece(Coordinates coords, Piece piece) {
        board[coords.getRow()][coords.getCol()] = piece;
    }

//    public void placePawnBlack(int row, int col) {
//        board[row][col] = new Pawn(PlayerColour.BLACK);
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