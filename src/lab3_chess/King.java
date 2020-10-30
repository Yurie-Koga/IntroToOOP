package lab3_chess;

public class King extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE_KING = 1_000;
    ///////////////////////////////////////////////////

    public King() {
        this(false);
    }

    public King(boolean isWhite) {
        super(VALUE_KING, isWhite);
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
