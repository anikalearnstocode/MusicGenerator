/*
 * Anika Krieger
 * Classes:
 * MelodyButton: super class for all buttons that use the MelodyLinkedList
 * PlayButton: plays the MelodyLinkedList
 * StopButton: stops MLL
 * LoopButton: loops MLL
 * Description: button classes for the linkedlistmelody generator
 */

package com.linked_list_music_template;

import processing.core.PApplet;

// melodybutton -- super class for all buttons that use the melodylinkedlist
public abstract class MelodyButton extends Button {

    LinkedListMelody melody; //linkled list melody to control

        //overload the constructor for MelodyButton - use default constructor for h, w, color
    MelodyButton(PApplet main_, LinkedListMelody melody_, String label_,float x_, float y_) {
        super(main_, label_, x_, y_); 
        melody = melody_;
    }

    public abstract void onPress();

}

// Playbutton -- play the melodylinkedlist
 class PlayButton extends MelodyButton {

    //overload the constructor for MelodyButton -- use default constructor for h, w, color
    PlayButton(PApplet main_, LinkedListMelody melody_, float x_, float y_) {
        super(main_, melody_, "Play", x_, y_); 
    }

    //start the melody
    @Override
    public void onPress() {
        melody.start();
    }
}

class StopButton extends MelodyButton {
    //overload the constructor for MelodyButton -- use default constructor for h, w, color
    StopButton (PApplet main_, LinkedListMelody melody_, float x_, float y_) {
    
        super(main_, melody_, "Stop", x_, y_); 
    }
    
        //start the melody
        @Override
        public void onPress() {
    
            melody.stop();
        }
    }

    class LoopButton extends MelodyButton {

        //overload the constructor for MelodyButton -- use default constructor for h, w, color
        LoopButton(PApplet main_, LinkedListMelody melody_, float x_, float y_) {
    
            super(main_, melody_, "Loop", x_, y_); 
        }
    
        //start the melody
        @Override
        public void onPress() {
    
            melody.loop(true);
            //System.out.println("loop button pressed");
        }
    }
