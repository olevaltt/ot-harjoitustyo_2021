
package Chordtrainer.domain;
import java.util.ArrayList;


public class ChordHandler {
    
    
    public ArrayList<Chord> placeholdername(String scalename) {

        
        int[] chordInfo = new int[6];
        chordInfo[0] = -1;
        chordInfo[1] = -1;
        chordInfo[2] = 0;
        chordInfo[3] = 2;
        chordInfo[4] = 3;
        chordInfo[5] = 2;
        
        Chord D = new Chord("D",1,chordInfo);
        //System.out.println("I am working!!!!");
        ArrayList<Chord> chords = new ArrayList<>();
        chords.add(D);
        
        return chords;
    }
    
    
}
