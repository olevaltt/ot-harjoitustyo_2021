
package Chordtrainer.domain;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;








public class ChordHandlerTest {
    
    ChordHandler handler;
    Chord A;
    Chord Am;
    Chord Adim;
    Chord Asharp;
    Chord Asharpm;
    Chord Asharpdim;
    Chord B;
    Chord Bm;
    Chord Bdim;
    Chord C;
    Chord Cm;
    Chord Cdim;
    Chord Csharp;
    Chord Csharpm;
    Chord Csharpdim;
    Chord D;
    Chord Dm;
    Chord Ddim;
    Chord Dsharp;
    Chord Dsharpm;
    Chord Dsharpdim;
    Chord E;
    Chord Em;
    Chord Edim;
    Chord F;
    Chord Fm;
    Chord Fdim;
    Chord Fsharp;
    Chord Fsharpm;
    Chord Fsharpdim;
    Chord G;
    Chord Gm;
    Chord Gdim;
    Chord Gsharp;
    Chord Gsharpm;
    Chord Gsharpdim;
    
    
    
    
    
    public ChordHandlerTest() {
        handler = new ChordHandler();
        A = new Chord("A", 1, (new int[]{-1, 0, 2, 2, 2, 0}));
        Am = new Chord("Am", 1, (new int[]{-1, 0, 2, 2, 1, 0}));
        Adim = new Chord("Adim", 4, (new int[]{-1, -1, 4, 2, 1, 2}));
        Asharp = new Chord("A#", 1, (new int[]{-1, 1, 3, 3, 3, 1}));
        Asharpm = new Chord("A#m", 1, (new int[]{-1, 1, 3, 3, 2, 1}));
        Asharpdim = new Chord("A#dim", 1, (new int[]{-1, 1, 2, 3, 2, 0}));
        B = new Chord("B", 2, (new int[]{-1, 1, 3, 3, 3, 1}));
        Bm = new Chord("Bm", 2, (new int[]{-1, 1, 3, 3, 2, 1}));
        Bdim = new Chord("Bdim", 1, (new int[]{-1, -1, 0, 4, 0, 1}));
        C = new Chord("C", 1, (new int[]{-1, 3, 2, 0, 1, 0}));
        Cm = new Chord("Cm", 3, (new int[]{-1, 1, 3, 3, 2, 1}));
        Cdim = new Chord("Cdim", 7, (new int[]{-1, -1, 4, 2, 1, 2}));
        Csharp = new Chord("C#", 4, (new int[]{-1, 1, 3, 3, 3, 1}));
        Csharpm = new Chord("C#m", 4, (new int[]{-1, 1, 3, 3, 2, 1}));
        Csharpdim = new Chord("C#dim", 1, (new int[]{-1, 4, 2, 0, 2, 0}));
        D = new Chord("D", 1, new int[]{-1, -1, 0, 2, 3, 2});
        Dm = new Chord("Dm", 1, new int[]{-1, -1, 0, 2, 3, 1});
        Ddim = new Chord("Ddim", 1, (new int[]{-1, -1, 0, 1, 3, 1}));
        Dsharp = new Chord("D#", 6, new int[]{-1, 1, 3, 3, 3, 1});
        Dsharpm = new Chord("D#m", 6, new int[]{-1, 1, 3, 3, 2, 1});
        Dsharpdim = new Chord("D#dim", 2, new int[]{-1, -1, 3, 1, 3, 1});
        E = new Chord("E", 1, (new int[]{0, 2, 2, 0, 0, 0}));
        Em = new Chord("Em", 1, (new int[]{0, 2, 2, 0, 0, 0}));
        Edim = new Chord("Edim", 3, (new int[]{-1, -1, 3, 1, 3, 1}));
        F = new Chord("F", 1, (new int[]{1, 3, 3, 2, 1, 1}));
        Fm = new Chord("Fm", 1, (new int[]{1, 3, 3, 1, 1, 1}));
        Fdim = new Chord("Fdim", 4, (new int[]{-1, -1, 3, 1, 3, 1}));
        Fsharp = new Chord("F#", 2, (new int[]{1, 3, 3, 2, 1, 1}));
        Fsharpm = new Chord("F#m", 2, (new int[]{1, 3, 3, 1, 1, 1}));
        Fsharpdim = new Chord("Fdim", 5, (new int[]{-1, -1, 3, 1, 3, 1}));
        G = new Chord("G", 1, (new int[]{3, 2, 0, 0, 0, 3}));
        Gm = new Chord("Gm", 3, (new int[]{1, 3, 3, 1, 1, 1}));
        Gdim = new Chord("Fdim", 6, (new int[]{-1, -1, 3, 1, 3, 1}));
        Gsharp = new Chord("G#", 4, (new int[]{1, 3, 3, 2, 1, 1}));
        Gsharpm = new Chord("G#m", 4, (new int[]{1, 3, 3, 1, 1, 1}));
        Gsharpdim = new Chord("G#dim", 1, (new int[]{-1, -1, 0, 1, 0, 4}));
        
    }
    
    
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
