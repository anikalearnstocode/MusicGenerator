/*
 * Anika Krieger
 * Class: LinkedListMelody
 * Description: 
 * 
 */


package com.linked_list_music_template;

public class LinkedListMelody implements Drawable {

    private MelodyNode head; //head of linked list
    MelodyNode curPlayingNode = null; //initialize to null since nothing is playing

    public LinkedListMelody() {
        this.head = null; //initialize head to null
    }

    //draw method from drawable interface
    public void draw() {
        play();
    }

    public void start() {
        if (head!= null) {
            curPlayingNode = head; //start from the head
            head.start();
            curPlayingNode.start(); //start first melody node
        }
    }

    //play each node in the list
    public void play() {
        //check if curPlayingNode is NOT null
        if (curPlayingNode != null) {
            if (curPlayingNode.atEnd()) {
                curPlayingNode = curPlayingNode.getNext();

                if (curPlayingNode != null) {
                    curPlayingNode.start();
                }
            }
        }
        //check if curPlayingNode is at the end - add atEnd();

        //if so, play next node unless it is null
    }

    public void insertAtStart (MelodyNode node) {
        node.setNext(head);
        head = node;
    }

    public void insertAtEnd(MelodyNode node) {
        if (head == null) {
            head = node;
        } else {
            MelodyNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void print() {
        MelodyNode current = head;
        StringBuilder melodyString = new StringBuilder("Melody: ");

        while (current != null) {
            melodyString.append(current.getMelodyIndex());
            current = current.getNext();
            if (current != null) {
                melodyString.append(", ");
            }
        }
    }
}
