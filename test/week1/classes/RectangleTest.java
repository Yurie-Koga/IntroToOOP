package week1.classes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    void testDraw() {
        Object[][][] cases = new Object[][][] {
                {{5, 7, "Blue"}, {"BBBBB\nBBBBB\nBBBBB\nBBBBB\nBBBBB\nBBBBB\nBBBBB"}},
                {{10, 2, "Green"}, {"GGGGGGGGGG\nGGGGGGGGGG"}},
                {{15, 12, "Red"}, {"RRRRRRRRRRRRRRR\nRRRRRRRRRRRRRRR\nRRRRRRRRRRRRRRR\nRRRRRRRRRRRRRRR\nRRRRRRRRRRRRRRR\nRRRRRRRRRRRRRRR\nRRRRRRRRRRRRRRR\nRRRRRRRRRRRRRRR\nRRRRRRRRRRRRRRR\nRRRRRRRRRRRRRRR\nRRRRRRRRRRRRRRR\nRRRRRRRRRRRRRRR"}},
                {{10, 2, "ab3"}, {"AAAAAAAAAA\nAAAAAAAAAA"}},
                {{5, 3, "Red4567890123456789"}, {"RRRRR\nRRRRR\nRRRRR"}},
                {{6, 3}, {"BBBBBB\nBBBBBB\nBBBBBB"}},
                {{5, 7, "12"}, {"Color has to be more than 2 characters long and less than 20."}},
                {{5, 3, "Red45678901234567890"}, {"Color has to be more than 2 characters long and less than 20."}},
        };
        for(Object[][] c: cases){
            String expected = c[1][0].toString();
            String actual;
            if (c[0].length > 2){
                Rectangle r = new Rectangle((int)c[0][0], (int)c[0][1], c[0][2].toString());
                actual = r.draw();
            }else{
                Rectangle r = new Rectangle((int)c[0][0], (int)c[0][1]);
                actual = r.draw();
            }
            Assertions.assertEquals(expected, actual);
        }
    }
}