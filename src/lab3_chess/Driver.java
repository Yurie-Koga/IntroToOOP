package lab3_chess;

import java.util.ArrayList;

/** what to test in Driver.java
 * Create an ArrayList<Piece> to include all types of pieces.
 * Using for-each loop, call move() method on each Piece to print the moves.
 * Create the following Pawns,
 * p1={value=1, isWhite=true, promoted=true, newPiece=Queen}
 * p2={value=1, isWhite=true, promoted=false, newPiece=null}
 * p3={value=1, isWhite=false, promoted=false, newPiece=null}
 * p4={value=1, isWhite=false, promoted=true, newPiece=Queen}
 * p5={value=1, isWhite=true, promoted=true, newPiece=Knight}
 * Use equals() method to compare the following:
 * p1.equals(p2) should return false
 * p1.equals(p4) should return false
 * p1.equals(p5) should return false
 * p2.equals(p3) should return false
 * p4.equals(p5) should return false
 */
public class Driver {
    public static void main(String[] args) {
        ArrayList<Piece> pieces = new ArrayList<>();
        // add all types
        pieces.add(new Pawn());
        pieces.add(new Knight());
        pieces.add(new Bishop());
        pieces.add(new Rook());
        pieces.add(new Queen());
        pieces.add(new King());

        // print each move
        System.out.println("----- each move -----");
        for (Piece p : pieces) {
            System.out.print(p + ": ");
            p.move();
        }

        // Pawns: set the same color with Pawn and a new piece since the location does not change
        Pawn p1 = new Pawn(true, true, new Queen(true));
        Pawn p2 = new Pawn(true, false, null);
        Pawn p3 = new Pawn(false, false, null);
        Pawn p4 = new Pawn(false, true, new Queen(false));
        Pawn p5 = new Pawn(true, true, new Knight(true));

        // equals
        System.out.println("----- equals -----");
        System.out.println(p1.equals(p2));
        System.out.println(p1.equals(p4));
        System.out.println(p1.equals(p5));
        System.out.println(p2.equals(p3));
        System.out.println(p4.equals(p5));
    }
}
