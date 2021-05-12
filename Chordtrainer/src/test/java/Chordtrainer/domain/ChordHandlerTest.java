
package Chordtrainer.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;







public class ChordHandlerTest {
    
    ChordHandler handler;
    
    public ChordHandlerTest() {
        handler = new ChordHandler();
    }
    /*
    @BeforeEach                                         
    public void setUp() throws Exception {
        handler = new ChordHandler();
    }
    */
    
    
    @Test
    public void createdHandlerExists() {
        assertTrue(handler != null);
    }
    
    @Test
    public void handlerReturnsChord() {
        Chord chord = handler.getNextChord(Scale.A);
        assertTrue(chord != null);
    }
}
