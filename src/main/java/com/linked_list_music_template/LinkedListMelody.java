/*
 * c2024  [your name] using a template by Dr. Courtney Brown
 * Class: LinkedListMelody
 * Description: [you fille in]
 * 
 */


package com.linked_list_music_template;

public class LinkedListMelody implements Drawable {

    //fill in this class
    public void draw()
    {
        //fill this in to play melody
    }

    MelodyNode curPlayingNode = null; //initialize to null since nothing is playing
    public void start() {

        if (head!= null) {
            curPlayingNode = head;
            head.start();
        }
    }
}
