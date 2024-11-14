/*
 * Anika Krieger
 * WeaveUnitTest class
 * Description: This class provides unit tests for the `weave` functionality of the `LinkedListMelody` class.
 * The `weave` method inserts a specified melody node into the linked list at regular intervals.
 * The WeaveUnitTest class sets up test cases to verify that the `weave` function works as expected.
 * It includes two primary test methods: `testWeave1` and `testWeave2`, which demonstrate different weaving patterns.
 */

package com.linked_list_music_template;

public class WeaveUnitTest {
    MelodyManager manager; //object reference to MelodyManager class
    LinkedListMelody melodyList; //linkedlistmelody object

    //constructor
    public WeaveUnitTest(MelodyManager manager_) {
        manager  = manager_; //initialize MelodyManager here
        melodyList = new LinkedListMelody();

    }

    //test weave 1
    public void testWeave1() {
        for (int i = 0; i < 12; i++) {
            melodyList.insertAtEnd(new MelodyNode(manager, 3));
        }

        //call the weave function
        melodyList.weave(new MelodyNode(manager, 0), 3, 4);


        //print the melody
        System.out.println("Expected: 3, 3, 3, 0, 3, 3, 3, 0, 3, 3, 3, 0, 3, 3, 3, 0");
        melodyList.print(); //expected output is Melody: 3, 3, 3, 0, 3, 3, 3, 0, 3, 3, 3, 0, 3, 3, 3, 0
    }

    //sets up a linkedlist melody with 12 nodes, each containing melody index 3
    //calls weave function to insert a new node with melody index 0 starting at the 5th position and repeating every 10th
    public void testWeave2() {
        melodyList = new LinkedListMelody();
        for (int i = 0; i < 12; i++) {
            melodyList.insertAtEnd(new MelodyNode(manager, 3));
        }

        melodyList.weave(new MelodyNode(manager, 0), 5, 10);

        System.out.println("Expected: 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 0, 3, 3");
        melodyList.print();
    }

    //test insertAtStart
    public void testInsertAtStart() {
        melodyList.insertAtStart(new MelodyNode(manager, 1));
        melodyList.insertAtStart(new MelodyNode(manager, 2));
        System.out.println("Expected: 2, 1");
        melodyList.print();
    }

    //test insertAtEnd
    public void testInsertAtEnd() {
        melodyList.insertAtEnd(new MelodyNode(manager, 3));
        melodyList.insertAtEnd(new MelodyNode(manager, 4));
        System.out.println("Expected: 3, 4");
        melodyList.print();
    }

    //test insert at specific index
    public void testInsert() {
        melodyList.insertAtEnd(new MelodyNode(manager, 5));
        melodyList.insert(1, new MelodyNode(manager, 6));
        melodyList.insert(0, new MelodyNode(manager, 7));
        System.out.println("Expected: 7, 5, 6");
        melodyList.print();
    }

    //test is empty
    public void testIsEmpty() {
        System.out.println("Expected: true, " + melodyList.isEmpty());
        melodyList.insertAtEnd(new MelodyNode(manager, 8));
        System.out.println("Expected: false, " + melodyList.isEmpty());
    }

    //test loop
    public void testLoop() {
        melodyList.loop(true);
        System.out.println("Expected: Looping set to true.");
        melodyList.loop(false);
        System.out.println("Expected: Looping set to false.");
    }

    //test stop
    public void testStop() {
        melodyList.insertAtEnd(new MelodyNode(manager, 9));
        melodyList.start();
        melodyList.loop(true);
        melodyList.stop();
        System.out.println("Expected: curPlayingNode is null, looping is false");
    }

    //test reverse
    public void testReverse() {
        melodyList.insertAtEnd(new MelodyNode(manager, 10));
        melodyList.insertAtEnd(new MelodyNode(manager, 11));
        melodyList.insertAtEnd(new MelodyNode(manager, 12));
        melodyList.reverse();
        System.out.println("Expected: 12, 11, 10");
        melodyList.print();
    }

    //test addAfterIndex
    public void testAddAfterIndex() {
        melodyList.insertAtEnd(new MelodyNode(manager, 13));
        melodyList.insertAtEnd(new MelodyNode(manager, 14));
        melodyList.addAfterIndex(13, new MelodyNode(manager, 15));
        System.out.println("Expected: 13, 15, 14");
        melodyList.print();
    }

    //test clear
    public void testClear() {
        melodyList.insertAtEnd(new MelodyNode(manager, 16));
        melodyList.clear();
        System.out.println("Expected: Melody is empty.");
        melodyList.print();
    }

    //run all tests
    public void runTests() {
        testWeave1();
        testWeave2();
        testInsertAtEnd();
        testInsertAtStart();
        testInsert();
        testIsEmpty();
        testLoop();
        testStop();
        testReverse();
        testAddAfterIndex();
        testClear();
    }

}
