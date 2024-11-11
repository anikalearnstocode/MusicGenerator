/*
 * Anika Krieger
 * WeaveUnitTest class
 * Description:
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
            //melodyList.addNode(new MelodyNode(manager, 3));
        }

        //call the weave function
        //melodyList.weave(melodyList.getHead(), 3, 4);
        melodyList.weave(new MelodyNode(manager, 0), 3, 4);


        //print the melody
        System.out.println("Expected: 3, 3, 3, 0, 3, 3, 3, 0, 3, 3, 3, 0, 3, 3, 3, 0");
        melodyList.print(); //expected output is Melody: 3, 3, 3, 0, 3, 3, 3, 0, 3, 3, 3, 0, 3, 3, 3, 0
    }
    

    public void testWeave2() {
        melodyList = new LinkedListMelody();
        for (int i = 0; i < 12; i++) {
            melodyList.insertAtEnd(new MelodyNode(manager, 3));
        }

        melodyList.weave(new MelodyNode(manager, 0), 5, 10);

        System.out.println("Expected: 3, 3, 3, 3, 3, 0, 3, 3, 3, 3, 3, 0, 3, 3");
        melodyList.print();
    }

    public void runTests() {
        testWeave1();
        testWeave2();
    }

}
