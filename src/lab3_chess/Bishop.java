package lab3_chess;

public class Bishop extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE_BISHOP = 3;
    ///////////////////////////////////////////////////

    public Bishop() { this(false);
    }

    public Bishop(boolean isWhite) {
        super(VALUE_BISHOP, isWhite);
    }

    @Override
    public void move() {
        System.out.println("Diagonally");
    }

    @Override
    public String toString() {
        return "Bishop{" +
                "value=" + getValue() +
                '}';
    }
}
