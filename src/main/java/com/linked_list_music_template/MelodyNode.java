/*
 * Anika Krieger
 * Class: LinkedListMelody
 * Description: 
 */

package com.linked_list_music_template;

public class MelodyNode {

    MelodyManager melodies;
    MelodyNode next;
    int whichMelody;

    //constructor
    public MelodyNode(MelodyManager melodies, int whichMelody) {
        this.melodies = melodies;
        //this.melodies = null;
        this.whichMelody = whichMelody;
        this.next = null;
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

    public void start() {
        if (melodies != null) {
            melodies.start(whichMelody);
        }
    }

    // public void getNext() {
    //     return whichMelody;
    // }

    public MelodyNode copy() {
        MelodyNode copyNode = new MelodyNode (melodies, this.whichMelody);
        copyNode.setNext(this.next);
        return copyNode;
    }

    public int getMelodyIndex() {
        return whichMelody;
    }

}
