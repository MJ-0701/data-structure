package ex01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueClassTest {

    @Test
    void queueTest(){
        QueueClass queueClass = new QueueClass();

        queueClass.queueLinkedList();
    }

}