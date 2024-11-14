/*
 * Anika Krieger
 * Class: LinkedListMelody
 * Description: The MelodyManager class manages and plays back MIDI melodies using MelodyPlayer instances.
 * It loads MIDI files, extracts note data, and initializes players for each MIDI voice.
 * Core functionalities include adding MIDI files, playing melodies, and resetting playback.
 * 
 */


package com.linked_list_music_template;

import java.util.ArrayList;


public class MelodyManager {

    MelodyPlayer player; // A player to manage and play a specific MIDI sequence
    ArrayList<MidiFileToNotes> midiNotes; // Holds MIDI file notes data for each loaded file
    ArrayList<MelodyPlayer> players; // ArrayList of MelodyPlayer instances, each playing a different melody

    //constructor
    MelodyManager()
    {
        players = new ArrayList<>();
        midiNotes = new ArrayList<>();
    }

    //plays all melodies in the players list
    public void playMelodies()
    {
       assert(player != null);
       for (MelodyPlayer player : players)
            player.play(); 
    }

    //opens the midi file, extracts a voice, then initializes a melody player with that midi voice (e.g. the melody)
    void addMidiFiles(String filePath) {
        int index = players.size();
        players.add( new MelodyPlayer(100, "Bus 1")); //sets up the player with your bus. 
        midiNotes.add(new MidiFileToNotes(filePath)); // creates a new MidiFileToNotes
        int noteCount = midiNotes.get(index).getPitchArray().size(); //get the number of notes in the midi file
        assert(noteCount > 0); // make sure it got some notes
        //sets the player to the melody to play the voice grabbed from the midi file above
        players.get(index).setMelody(midiNotes.get(index).getPitchArray());
        players.get(index).setRhythm(midiNotes.get(index).getRhythmArray());
        players.get(index).setStartTimes(midiNotes.get(index).getStartTimeArray());

        players.get(index).setToEnd();
    }

    //resets a melodyplayer at a specified index in players to the beginning of its melodoy
    void start(int index)
    {
        players.get(index).reset();
    }

    //checks if a specified melodyplayer has reached the end of its melody
    //returns boolean as true if at the end of the melody and false otherwise
    boolean atEnd (int index) {

        return players.get(index).atEndOfMelody();
    }

    //currently empty but serves as a little placeholder for future implementation of specific melody playback
    public void playMelody(int melodyIndex) {
    
    }
}

