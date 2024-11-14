/*
 * Anika Krieger
 * Classes:
 * MelodyButton: super class for all buttons that use the MelodyLinkedList
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

//playbutton starts the linkedlistmelody playback
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

//stopbutton stops the linkedlistmelody playback
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
    
    //loopbutton toggles looping of the linkedlistmelody
    class LoopButton extends MelodyButton {

        //overload the constructor for MelodyButton -- use default constructor for h, w, color
        LoopButton(PApplet main_, LinkedListMelody melody_, float x_, float y_) {
    
            super(main_, melody_, "Loop", x_, y_); 
        }
    
        //start the melody
        @Override
        public void onPress() {
    
            melody.loop(true);
        }
    }

    //weavebutton1 initiates the first weaving pattern on the linkedlistmelody
    class WeaveButton1 extends MelodyButton {

        WeaveButton1(PApplet main_, LinkedListMelody melody_, float x_, float y_) {
    
            super(main_, melody_, "Weave 1", x_, y_); 
        }
    
        //start the melody
        @Override
        public void onPress() {

            melody.startWeave1(); //apply weave pattern 1
        }
    }

    //weavebutton2 initiates the second weaving pattern on the linkedlistmelody
    class WeaveButton2 extends MelodyButton {

        WeaveButton2(PApplet main_, LinkedListMelody melody_, float x_, float y_) {
    
            super(main_, melody_, "Weave 2", x_, y_); 
        }
    
        //start the melody
        @Override
        public void onPress() {

            melody.startWeave2(); //apply weave pattern 2
        }
    }

    //printmelody prints the structure of the linkedlistmelody to the console
    class PrintMelody extends MelodyButton {

        PrintMelody(PApplet main_, LinkedListMelody melody_, float x_, float y_) {
    
           super(main_, melody_, "Print Melody", x_, y_); 
        }
    
        //start the melody
        @Override
        public void onPress() {

            melody.print(); //output melody structure
        }
    }

    //weaveunittestbutton runs unit tests on weaving patterns for linkedlistmelody
    class WeaveUnitTestButton extends MelodyButton {

        WeaveUnitTest weaveUnitTest;


        WeaveUnitTestButton(PApplet main_, LinkedListMelody melody_, float x_, float y_, MelodyManager manager_) {
    
            super(main_, melody_, "Weave Unit Test", x_, y_); 
            weaveUnitTest = new WeaveUnitTest(manager_); //initialize with melody manager


        }
    
        //start the melody
        @Override
        public void onPress() {

            weaveUnitTest.runTests(); //execute weaving unit tests
        }
    }

    //reverselist reverses the order of nodes in the linledlistmelody
    class ReverseList extends MelodyButton {

        ReverseList(PApplet main_, LinkedListMelody melody_, float x_, float y_) {
    
            super(main_, melody_, "Reverse", x_, y_); 
        }
    
        //start the melody
        @Override
        public void onPress() {

            melody.reverse(); //reverse melody node order
        }
    }

    //clearlist clears all nodes in the linkedlistmelody
    class ClearList extends MelodyButton {

        ClearList(PApplet main_, LinkedListMelody melody_, float x_, float y_) {
    
            super(main_, melody_, "Clear", x_, y_); 
        }
    
        //start the melody
        @Override
        public void onPress() {

            melody.clear(); //clear melody nodes
        }
    }