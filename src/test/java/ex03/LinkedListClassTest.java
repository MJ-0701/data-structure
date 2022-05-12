package ex03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListClassTest {


    @Test
    void LinkedListTest(){
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);

//        System.out.println(linkedList.head); // -> 주솟값
//        System.out.println(linkedList.head.data); // -> 1
//        System.out.println(linkedList.head.next); // null

        // 1 뒤에 5 넣어 보기
        linkedList.addNodeInside(5,1);
//        linkedList.printAll(); // 1 5 2 3

        // 3(맨 마지막) 뒤에 6 넣어보기
        linkedList.addNodeInside(6,3);
//        linkedList.printAll(); // 1 5 2 3 6

        // 없는 데이터의 앞에 끼워 넣어보기
        linkedList.addNodeInside(7,20);
        linkedList.printAll(); // 7이 맨 뒤로 들어감.



    }

    @Test
     void delNodeTest(){
        SingleLinkedList<Integer> linkedList = new SingleLinkedList<Integer>();
        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addNode(5);

        // 중간 노드 삭제
        linkedList.delNode(3); // 1,2,4,5


        // 헤드 삭제
        linkedList.delNode(1); // 2,4,5


        // 맨 마지막 노드 삭제
        linkedList.delNode(5); // 2,4

        // 없는 노드 삭제
        Assertions.assertTrue(linkedList.delNode(20)); // false -> 테스트 실패

        linkedList.printAll();
     }

}