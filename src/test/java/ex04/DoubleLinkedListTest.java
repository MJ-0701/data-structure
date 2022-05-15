package ex04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    @Test
    void doubleLinkedList(){
        DoubleLinkedList<Integer> doubleLinkedList = new DoubleLinkedList<Integer>();
        doubleLinkedList.addNode(1);
        doubleLinkedList.addNode(2);
        doubleLinkedList.addNode(3);
        doubleLinkedList.addNode(4);
        doubleLinkedList.addNode(5);

        doubleLinkedList.printAll();

        Long headSearchStart = System.currentTimeMillis();
        doubleLinkedList.searchFromHead(1);
        Long headSearchEnd = System.currentTimeMillis();
       // Long headSearchTime = headSearchEnd - headSearchStart; // 0나와서 비교가 안됨.
        // start 와 end 같은 시간 나옴.
        System.out.println("headSearchStart :" + headSearchStart);
        System.out.println("headSearchEnd :" + headSearchEnd);

        Long tailSearchStart = System.currentTimeMillis();
        doubleLinkedList.searchFromTail(1);
        Long tailSearchEnd = System.currentTimeMillis();
        //Long tailSearchTime = tailSearchEnd - tailSearchStart;
        System.out.println("tailSearchStart :" + tailSearchStart);
        System.out.println("tailSearchEnd :" + tailSearchEnd);


    }

}