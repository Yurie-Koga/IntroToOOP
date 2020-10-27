package lab3_chess;

public class Queen extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE_QUEEN = 9;
    ///////////////////////////////////////////////////

    public Queen() {
        this(VALUE_QUEEN, false);
    }

    public Queen(int value, boolean isWhite) {
        super(value, isWhite);
    }

    @Override
    public void move() {
        System.out.println("Like bishop and rook");
    }

    @Override
    public String toString() {
        return "Queen{" +
                "value=" + getValue() +
                '}';
    }
}
