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
    private boolean isLooping = false; //control loop

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
        }
    }

    //play each node in the list
    public void play() {
        //check if curPlayingNode is NOT null
        if (curPlayingNode != null) {
            //System.out.println("Currently playing node index: " + curPlayingNode.getMelodyIndex());
            if (curPlayingNode.atEnd()) {
                //System.out.println("Reached the end of node: " + curPlayingNode.getMelodyIndex());
                curPlayingNode = curPlayingNode.getNext();

                if (curPlayingNode != null) {
                    System.out.println("Playing next node index: " + curPlayingNode.getMelodyIndex());
                    curPlayingNode.start();
                } else if (isLooping) {
                    System.out.println("Looping back to the head.");

                    start(); //restart from head if looping is true
                } else {
                    System.out.println("No more nodes to play and looping is off.");

                }
            }
        } else {
           //System.out.println("No current node to play.");

        }
    }

    public void insertAtStart (MelodyNode node) {
        System.out.println("Inserting node at start with melody index: " + node.getMelodyIndex());

        node.setNext(head);
        head = node;
    }

    public void insertAtEnd(MelodyNode node) {
       // System.out.println("List is empty. Adding node as head with melody index: " + node.getMelodyIndex());

        if (head == null) {
            head = node;
        } else {
            MelodyNode current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }

          //  System.out.println("Inserting node at end with melody index: " + node.getMelodyIndex());
            current.setNext(node);
        }
    }

    public void insert(int index, MelodyNode node) {
        if (index == 0) {
            insertAtStart(node);
        } else {
            MelodyNode current = head;
            for (int i = 0; i < index - 1 && current != null; i++) {
                current = current.getNext();
            }

            if (current != null) {
                node.setNext(current.getNext());
                current.setNext(node);
            }
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

        System.out.println(melodyString);
    }

    public void loop (boolean loop_) {
        isLooping = loop_;
        System.out.println("Looping set to:  " + isLooping);
    }

    public void stop() {
        curPlayingNode = null;
        isLooping = false; //disable looping
    }

    public void weave (MelodyNode node, int count, int skip) {
        MelodyNode current = head;
        int position = 0;

        while (current != null && count > 0) {
            position++;
            if (position % skip == 0) {
                MelodyNode weaveNode = new MelodyNode(node.melodies, node.getMelodyIndex());
                weaveNode.setNext(current.getNext());
                current.setNext(weaveNode);
                current = weaveNode.getNext();
                count--;
            } else {
                current = current.getNext();
            }
        }
    }

    public void clear() {
        System.out.println("Clearing the linked list.");

        head = null;
        curPlayingNode = null;
        isLooping = false;
    }

    public void reverse() {
        MelodyNode previous = null;
        MelodyNode current = head;
        MelodyNode next;

        while (current != null) {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        head = previous;
    }

    public void addAfterIndex(int targetIndex, MelodyNode newNode) {
        MelodyNode current = head;
        while (current != null) {
            if (current.getMelodyIndex() == targetIndex) {
                MelodyNode temp = new MelodyNode(newNode.melodies, newNode.getMelodyIndex());
                temp.setNext(current.getNext());
                current.setNext(temp);
                current = temp.getNext();
            } else {
                current = current.getNext();
            }
        }
    }

    public MelodyNode getHead() {
        return head;
    }

    public void startWeave1() {
        MelodyNode testNode = new MelodyNode(null, 0);
        
        weave(testNode, 3, 4);
    }

    public void startWeave2() {
        MelodyNode testNode = new MelodyNode(null, 0);
        weave(testNode, 5, 10);
    }

    // @BeforeEach
    // public void setUp() {
    //     melody = new LinkedListMelody();
    // }

}
