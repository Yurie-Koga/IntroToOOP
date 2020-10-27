package lab3_chess;

public class Rook extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE_ROOK = 5;
    ///////////////////////////////////////////////////

    public Rook() {
        this(VALUE_ROOK, false);
    }

    public Rook(int value, boolean isWhite) {
        super(value, isWhite);
    }

    @Override
    public void move() {
        System.out.println("Horizontally or vertically");
    }

    @Override
    public String toString() {
        return "Rook{" +
                "value=" + getValue() +
                '}';
    }
}

