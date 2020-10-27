package lab3_chess;

public class Knight extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE_KNIGHT = 2;
    ///////////////////////////////////////////////////

    public Knight() {
        this(VALUE_KNIGHT, false);
    }

    public Knight(int value, boolean isWhite) {
        super(value, isWhite);
    }

    @Override
    public void move() {
        System.out.println("Like an L");
    }

    @Override
    public String toString() {
        return "Knight{" +
                "value=" + getValue() +
                '}';
    }
}
