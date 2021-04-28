
package Chordtrainer.domain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;



public class ChordHandler {
    
    private ArrayList<Chord> aChords;
    private ArrayList<Chord> aSharpChords;
    private ArrayList<Chord> bChords;
    private ArrayList<Chord> cChords;
    private ArrayList<Chord> cSharpChords;
    private ArrayList<Chord> dChords;
    private ArrayList<Chord> dSharpChords;
    private ArrayList<Chord> eChords;
    private ArrayList<Chord> fChords;
    private ArrayList<Chord> fSharpChords;
    private ArrayList<Chord> gChords;
    private ArrayList<Chord> gSharpChords;
    private ArrayList<Chord> aMChords;
    private ArrayList<Chord> aSharpMChords;
    private ArrayList<Chord> bMChords;
    private ArrayList<Chord> cMChords;
    private ArrayList<Chord> cSharpMChords;
    private ArrayList<Chord> dMChords;
    private ArrayList<Chord> dSharpMChords;
    private ArrayList<Chord> eMChords;
    private ArrayList<Chord> fMChords;
    private ArrayList<Chord> fSharpMChords;
    private ArrayList<Chord> gMChords;
    private ArrayList<Chord> gSharpMChords;
    
    private HashMap<Scale,ArrayList<Chord>> scales;
    
    
    
    
    public ChordHandler() {
        
        this.scales = new HashMap<>();

        Chord D = new Chord("D",1,new int[]{-1,-1,0,2,3,2});
        
        
        int[] chordInfoEm = new int[6];
        chordInfoEm[0] = 0; 
        chordInfoEm[1] = 2;
        chordInfoEm[2] = 2;
        chordInfoEm[3] = 0;
        chordInfoEm[4] = 0;
        chordInfoEm[5] = 0;
        Chord Em = new Chord("Em",1,(chordInfoEm));
        
        
        int[] chordInfoFsharpm = new int[6]; 
        chordInfoFsharpm[0] = 1; 
        chordInfoFsharpm[1] = 3;
        chordInfoFsharpm[2] = 3;
        chordInfoFsharpm[3] = 1;
        chordInfoFsharpm[4] = 1;
        chordInfoFsharpm[5] = 1;
        Chord Fsharpm = new Chord("F#m",2,(chordInfoFsharpm));
        
        
        int[] chordInfoG = new int[6];
        chordInfoG[0] = 3; 
        chordInfoG[1] = 2;
        chordInfoG[2] = 0;
        chordInfoG[3] = 0;
        chordInfoG[4] = 0;
        chordInfoG[5] = 3;
        Chord G = new Chord("G",1,(chordInfoG));
        
        
        int[] chordInfoA = new int[6];
        chordInfoA[0] = -1; 
        chordInfoA[1] = 0;
        chordInfoA[2] = 2;
        chordInfoA[3] = 2;
        chordInfoA[4] = 2;
        chordInfoA[5] = 0;
        Chord A = new Chord("A",1,(chordInfoA));
        
        
        int[] chordInfoBm = new int[6];
        chordInfoBm[0] = -1; 
        chordInfoBm[1] = 1;
        chordInfoBm[2] = 3;
        chordInfoBm[3] = 3;
        chordInfoBm[4] = 2;
        chordInfoBm[5] = 1;
        Chord Bm = new Chord("Bm",2,(chordInfoBm));
        
        
        int[] chordInfoCsharpdim = new int[6];
        chordInfoCsharpdim[0] = -1; 
        chordInfoCsharpdim[1] = 4;
        chordInfoCsharpdim[2] = 2;
        chordInfoCsharpdim[3] = 0;
        chordInfoCsharpdim[4] = 2;
        chordInfoCsharpdim[5] = 0;
        Chord Csharpdim = new Chord("C#dim",1,(chordInfoCsharpdim));
        
        this.dChords = new ArrayList<>(Arrays.asList(D,Em,Fsharpm,G,A,Bm,Csharpdim));
        Collections.shuffle(this.dChords);
        this.scales.put(Scale.D, this.dChords);
        
    }
    
    
   
    
    public Chord getNextChord(Scale scale) {

        ArrayList<Chord> currentScale = this.scales.get(scale);
        Chord currentChord = currentScale.get(0);
        currentScale.remove(0);
        currentScale.add(currentChord);
        
        return currentChord;
    }
    
    
}
