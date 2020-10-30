package lab3_chess;

public class Knight extends Piece {
    ///////////////////////////////////////////////////
    private static final int VALUE_KNIGHT = 2;
    ///////////////////////////////////////////////////

    public Knight() {
        this(false);
    }

    public Knight(boolean isWhite) {
        super(VALUE_KNIGHT, isWhite);
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
