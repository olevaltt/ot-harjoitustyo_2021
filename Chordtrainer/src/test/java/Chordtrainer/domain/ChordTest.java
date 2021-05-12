
package Chordtrainer.domain;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ChordTest {
    
    Chord A;
    
    public ChordTest() {
        
        A = new Chord("A", 1, (new int[]{-1, 0, 2, 2, 2, 0}));
    }
    
}
