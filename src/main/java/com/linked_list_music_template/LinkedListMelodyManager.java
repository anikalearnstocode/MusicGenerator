/*
 * Anika Krieger
 * Class: LinkedListMelody
 * Description: Manages a collection of MIDI files in a linked list structure, inheriting core functionality
 * from the MelodyManager class. This class also implements the Drawable interface to enable real-time
 * interaction with the linked list and MIDI playback. Handles setup and playback of specified MIDI files.
 * 
 */

package com.linked_list_music_template;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

public class LinkedListMelodyManager extends MelodyManager implements Drawable {

    static FileSystem sys = FileSystems.getDefault(); //default system file separator for paths
    static String prependPath = "mid" + sys.getSeparator(); //path prefix for midi files
    static String appendType = ".mid" + sys.getSeparator(); //path suffix for midi files

    //array list of midi file names to load and manage
    String[] files = {"motive1Am", "motive2Am", "motive3Am", "motive1E", "motive2E", "motive3E", "new1", "new2", "new3", "new5", "new4"};

    //constructor
    LinkedListMelodyManager()
    {
        super();
    }

    //loads midi files into the manager
    void setup() {
        
        for (int i=0;i<files.length; i++) {
            addMidiFiles(prependPath+files[i]+appendType);
        }
    }

    //returns number of midi files currently managed in the files array
    int size() {

        return files.length;
    }

    //draws/plays the midi sequence
    public void draw() {

        playMelodies();
    }

}
