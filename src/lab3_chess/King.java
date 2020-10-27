package lab3_chess;

public class King extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE_KING = 1_000;
    ///////////////////////////////////////////////////

    public King() {
        this(VALUE_KING, false);
    }

    public King(int value, boolean isWhite) {
        super(value, isWhite);
    }

    @Override
    public void move() {
        System.out.println("One square");
    }

    @Override
    public String toString() {
        return "King{" +
                "value=" + getValue() +
                '}';
    }
}
