/*
 * Anika Krieger
 * Class: LinkedListMelody
 * Description: The MelodyNode class represents a node in a linked list for managing MIDI melodies.
 * Each node contains a reference to a MelodyManager, the specific melody within the manager it controls, and a link to the next node in the sequence.
 * This structure allows for sequential playback and control of melodies in a linked list format.
 */

package com.linked_list_music_template;

public class MelodyNode {

    MelodyManager melodies; // Reference to a MelodyManager instance for accessing and controlling melodies
    MelodyNode next; // Reference to the next node in the linked list
    int whichMelody; // Index of the melody within the MelodyManager that this node controls

    //constructor
    public MelodyNode(MelodyManager melodies, int whichMelody) {
        this.melodies = melodies;
        this.whichMelody = whichMelody;
        this.next = null; //initialize next as null, will be set later if linked to another node
    }

    //getter for next node
    public MelodyNode getNext() {
        return next;
    }

    //setter for next node
    public void setNext (MelodyNode next) {
        this.next = next;
    }

    //check melody manager if it is at the end time
    boolean atEnd() {
        return melodies != null && melodies.atEnd(whichMelody);
    }

    //starts or restarts playback of the melody associated with this node
    public void start() {
        if (melodies != null) {
            melodies.start(whichMelody);
        }
    }

    //creates a copy of this melodynode with the same melodymanager and melody index and links it to the same next node as the original
    //returns melodynode - a new node with identical data and link structure
    public MelodyNode copy() {
        MelodyNode copyNode = new MelodyNode (melodies, this.whichMelody);
        copyNode.setNext(this.next);
        return copyNode;
    }

    //returns the index of the melody associated with this node
    public int getMelodyIndex() {
        return whichMelody;
    }

}
