package ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListClassTest {


    @Test
    void LinkedListTest(){
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.addNode(1);

        System.out.println(linkedList.head); // -> 주솟값
        System.out.println(linkedList.head.data); // -> 1
        System.out.println(linkedList.head.next); // null

    }

}