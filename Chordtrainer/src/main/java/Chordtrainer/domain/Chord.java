
package Chordtrainer.domain;

        

public class Chord {
    
    //lists values represent the location where the string is pressed.
    //value of -1 means that the string isn't played at all.
    //value of 0 means that open string is played.
    //values 1-4 represent the position where a string is pressed beginning at the top of the fretboard.
    //values in the list are sorted in order: E A D G B e.
    private int[] chord;
    private int chordPosition;
    private String name;

    public Chord(int[] list, int position, String name) {
        this.name = name;
        this.chord = list;
        this.chordPosition = position;
    }
    
    public int[] getChord() {
        return this.chord;
    }
    
    public int getPosition() {
        return this.chordPosition;
    }
    
    public String getName() {
        return this.name;
    }
    
}
    
    
    
    
    
     

