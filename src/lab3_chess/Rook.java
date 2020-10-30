package lab3_chess;

public class Rook extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE_ROOK = 5;
    ///////////////////////////////////////////////////

    public Rook() {
        this(false);
    }

    public Rook(boolean isWhite) {
        super(VALUE_ROOK, isWhite);
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

