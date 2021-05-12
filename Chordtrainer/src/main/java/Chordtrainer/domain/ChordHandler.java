
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
    
    private HashMap<Scale, ArrayList<Chord>> scales;
    
    public ChordHandler() {
        
        this.scales = new HashMap<>();
        
        Chord A = new Chord("A", 1, (new int[]{-1, 0, 2, 2, 2, 0}));
        Chord Am = new Chord("Am", 1, (new int[]{-1, 0, 2, 2, 1, 0}));
        Chord Adim = new Chord("Adim", 4, (new int[]{-1, -1, 4, 2, 1, 2}));
        Chord Asharp = new Chord("A#", 1, (new int[]{-1, 1, 3, 3, 3, 1}));
        Chord Asharpm = new Chord("A#m", 1, (new int[]{-1, 1, 3, 3, 2, 1}));
        Chord Asharpdim = new Chord("A#dim", 1, (new int[]{-1, 1, 2, 3, 2, 0}));
        Chord B = new Chord("B", 2, (new int[]{-1, 1, 3, 3, 3, 1}));
        Chord Bm = new Chord("Bm", 2, (new int[]{-1, 1, 3, 3, 2, 1}));
        Chord Bdim = new Chord("Bdim", 1, (new int[]{-1, -1, 0, 4, 0, 1}));
        Chord C = new Chord("C", 1, (new int[]{-1, 3, 2, 0, 1, 0}));
        Chord Cm = new Chord("Cm", 3, (new int[]{-1, 1, 3, 3, 2, 1}));
        Chord Cdim = new Chord("Cdim", 7, (new int[]{-1, -1, 4, 2, 1, 2}));
        Chord Csharp = new Chord("C#", 4, (new int[]{-1, 1, 3, 3, 3, 1}));
        Chord Csharpm = new Chord("C#m", 4, (new int[]{-1, 1, 3, 3, 2, 1}));
        Chord Csharpdim = new Chord("C#dim", 1, (new int[]{-1, 4, 2, 0, 2, 0}));
        Chord D = new Chord("D", 1, new int[]{-1, -1, 0, 2, 3, 2});
        Chord Dm = new Chord("Dm", 1, new int[]{-1, -1, 0, 2, 3, 1});
        Chord Ddim = new Chord("Ddim", 1, (new int[]{-1, -1, 0, 1, 3, 1}));
        Chord Dsharp = new Chord("D#", 6, new int[]{-1, 1, 3, 3, 3, 1});
        Chord Dsharpm = new Chord("D#m", 6, new int[]{-1, 1, 3, 3, 2, 1});
        Chord Dsharpdim = new Chord("D#dim", 2, new int[]{-1, -1, 3, 1, 3, 1});
        Chord E = new Chord("E", 1, (new int[]{0, 2, 2, 0, 0, 0}));
        Chord Em = new Chord("Em", 1, (new int[]{0, 2, 2, 0, 0, 0}));
        Chord Edim = new Chord("Edim", 3, (new int[]{-1, -1, 3, 1, 3, 1}));
        Chord F = new Chord("F", 1, (new int[]{1, 3, 3, 2, 1, 1}));
        Chord Fm = new Chord("Fm", 1, (new int[]{1, 3, 3, 1, 1, 1}));
        Chord Fdim = new Chord("Fdim", 4, (new int[]{-1, -1, 3, 1, 3, 1}));
        Chord Fsharp = new Chord("F#", 2, (new int[]{1, 3, 3, 2, 1, 1}));
        Chord Fsharpm = new Chord("F#m", 2, (new int[]{1, 3, 3, 1, 1, 1}));
        Chord Fsharpdim = new Chord("Fdim", 5, (new int[]{-1, -1, 3, 1, 3, 1}));
        Chord G = new Chord("G", 1, (new int[]{3, 2, 0, 0, 0, 3}));
        Chord Gm = new Chord("Gm", 3, (new int[]{1, 3, 3, 1, 1, 1}));
        Chord Gdim = new Chord("Fdim", 6, (new int[]{-1, -1, 3, 1, 3, 1}));
        Chord Gsharp = new Chord("G#", 4, (new int[]{1, 3, 3, 2, 1, 1}));
        Chord Gsharpm = new Chord("G#m", 4, (new int[]{1, 3, 3, 1, 1, 1}));
        Chord Gsharpdim = new Chord("G#dim", 1, (new int[]{-1, -1, 0, 1, 0, 4}));
        
        this.aChords = new ArrayList<>(Arrays.asList(A, Bm, Csharpm, D, E, Fsharpm, Gsharpdim));
        Collections.shuffle(this.aChords);
        this.scales.put(Scale.A, this.aChords);
        
        this.aSharpChords = new ArrayList<>(Arrays.asList(Asharp, Cm, Dm, Dsharp, F, Gm, Adim));
        Collections.shuffle(this.aSharpChords);
        this.scales.put(Scale.A_SHARP, this.aSharpChords);
        
        this.bChords = new ArrayList<>(Arrays.asList(B, Csharpm, Dsharpm, E, Fsharp, Gsharpm, Asharpdim));
        Collections.shuffle(this.bChords);
        this.scales.put(Scale.B, this.bChords);
        
        this.cChords = new ArrayList<>(Arrays.asList(C, Dm, Em, F, G, Am, Bdim));
        Collections.shuffle(this.cChords);
        this.scales.put(Scale.C, this.cChords);
        
        this.cSharpChords = new ArrayList<>(Arrays.asList(Csharp, Dsharp, Fm, Fsharp, Gsharp, Asharpm, Cdim));
        Collections.shuffle(this.cSharpChords);
        this.scales.put(Scale.C_SHARP, this.cSharpChords);
        
        this.dChords = new ArrayList<>(Arrays.asList(D, Em, Fsharpm, G, A, Bm, Csharpdim));
        Collections.shuffle(this.dChords);
        this.scales.put(Scale.D, this.dChords);
        
        this.dSharpChords = new ArrayList<>(Arrays.asList(Dsharp, Fm, Gm, Gsharp, Asharp, Cm, Ddim));
        Collections.shuffle(this.dSharpChords);
        this.scales.put(Scale.D_SHARP, this.dSharpChords);
        
        this.eChords = new ArrayList<>(Arrays.asList(E, Fsharpm, Gsharpm, A, B, Csharpm, Dsharpdim));
        Collections.shuffle(this.eChords);
        this.scales.put(Scale.E, this.eChords);
        
        this.fChords = new ArrayList<>(Arrays.asList(F, Gm, Am, Asharp, C, Dm, Edim));
        Collections.shuffle(this.fChords);
        this.scales.put(Scale.F, this.fChords);
        
        this.fSharpChords = new ArrayList<>(Arrays.asList(Fsharp, Gsharpm, Asharpm, B, Csharp, Dsharpm, Fdim));
        Collections.shuffle(this.fSharpChords);
        this.scales.put(Scale.F_SHARP, this.fSharpChords);
        
        this.gChords = new ArrayList<>(Arrays.asList(G, Am, Bm, C, D, Em, Fsharpdim));
        Collections.shuffle(this.gChords);
        this.scales.put(Scale.G, this.gChords);
        
        this.gSharpChords = new ArrayList<>(Arrays.asList(Gsharp, Asharpm, Cm, Csharp, Dsharp, Fm, Gdim));
        Collections.shuffle(this.gSharpChords);
        this.scales.put(Scale.G_SHARP, this.gSharpChords);
        
        this.aMChords = new ArrayList<>(Arrays.asList(Am, Bdim, C, Dm, Em, F, G));
        Collections.shuffle(this.aMChords);
        this.scales.put(Scale.A_M, this.aMChords);
        
        this.aSharpMChords = new ArrayList<>(Arrays.asList(Asharpm, Cdim, Csharp, Dsharpm, Fm, Fsharp, Gsharp));
        Collections.shuffle(this.aSharpMChords);
        this.scales.put(Scale.A_SHARP_M, this.aSharpMChords);
        
        this.bMChords = new ArrayList<>(Arrays.asList(Bm, Csharpdim, D, Em, Fsharpm, G, A));
        Collections.shuffle(this.bMChords);
        this.scales.put(Scale.B_M, this.bMChords);
        
        this.cMChords = new ArrayList<>(Arrays.asList(Cm, Ddim, Dsharp, Fm, Gm, Gsharp, Asharp));
        Collections.shuffle(this.cMChords);
        this.scales.put(Scale.C_M, this.cMChords);
        
        this.cSharpMChords = new ArrayList<>(Arrays.asList(Csharpm, Dsharpdim, E, Fsharpm, Gsharpm, A, B));
        Collections.shuffle(this.cSharpMChords);
        this.scales.put(Scale.C_SHARP_M, this.cSharpMChords);
        
        this.dMChords = new ArrayList<>(Arrays.asList(Dm, Edim, F, Gm, Am, Asharp, C));
        Collections.shuffle(this.dMChords);
        this.scales.put(Scale.D_M, this.dMChords);
        
        this.dSharpMChords = new ArrayList<>(Arrays.asList(Dsharpm, Fdim, Fsharp, Gsharpm, Asharpm, B, Csharp));
        Collections.shuffle(this.dSharpMChords);
        this.scales.put(Scale.D_SHARP_M, this.dSharpMChords);
        
        this.eMChords = new ArrayList<>(Arrays.asList(Em, Fsharpdim, G, Am, Bm, C, D));
        Collections.shuffle(this.eMChords);
        this.scales.put(Scale.E_M, this.eMChords);
        
        this.fMChords = new ArrayList<>(Arrays.asList(Fm, Gdim, Gsharp, Asharpm, Cm, Csharp, Dsharp));
        Collections.shuffle(this.fMChords);
        this.scales.put(Scale.F_M, this.fMChords);
        
        this.fSharpMChords = new ArrayList<>(Arrays.asList(Fsharpm, Gsharpdim, A, Bm, Csharpm, D, E));
        Collections.shuffle(this.fSharpMChords);
        this.scales.put(Scale.F_SHARP_M, this.fSharpMChords);
        
        this.gMChords = new ArrayList<>(Arrays.asList(Gm, Adim, Asharp, Cm, Dm, Dsharp, F));
        Collections.shuffle(this.gMChords);
        this.scales.put(Scale.G_M, this.gMChords);
        
        this.gSharpMChords = new ArrayList<>(Arrays.asList(Gsharpm, Asharpdim, B, Csharpm, Dsharpm, E, Fsharp));
        Collections.shuffle(this.gSharpMChords);
        this.scales.put(Scale.G_SHARP_M, this.gSharpMChords);
    }
    
    public Chord getNextChord(Scale scale) {

        ArrayList<Chord> currentScale = this.scales.get(scale);
        Chord currentChord = currentScale.get(0);
        currentScale.remove(0);
        currentScale.add(currentChord);
        
        return currentChord;
    }   
}
