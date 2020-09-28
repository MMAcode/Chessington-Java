package training.chessington.model;

import java.util.ArrayList;
import java.util.List;

public class Moves {
    private List<Move> moves;

    public Moves(List<Move> moves) {
        this.moves = moves;
    }
    public Moves() {
        this.moves = new ArrayList<>();
    }

    public List<Move> get() {
        return moves;
    }

    public void addIfExists(List<Move> moves) {
        if (moves!=null && moves.size()>0) this.moves.addAll(moves);
    }
    public void addIfExists(Move move) {
        if (move!=null) this.moves.add(move);
    }
}
