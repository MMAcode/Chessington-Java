package training.chessington.model;

import java.util.Objects;

public final class Coordinates {
    private final int row;
    private final int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return row == that.row &&
                col == that.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        return String.format("row %d, column %d", row, col);
    }

    public Coordinates plus(int rowDiff, int colDiff) {
        return new Coordinates(row + rowDiff, col + colDiff);
    }

    public boolean existOnTheBoard(){
        return (this.getRow()>=0 && this.getCol() >= 0)&&(this.getRow()<=7 && this.getCol() <= 7);
    }

    public Coordinates getNextSquareInDirection (String direction){
        int extraCol = 0;
        int extraRow = 0;
        if (direction.contains("Up")) extraRow--;
        if (direction.contains("Down")) extraRow++;
        if (direction.contains("Right")) extraCol++;
        if (direction.contains("Left")) extraCol--;
        return new Coordinates(this.getRow()+extraRow,this.getCol()+extraCol);
    }
}
