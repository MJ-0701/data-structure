package ex02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void myStackTest(){

        MyStack<Integer> stack = new MyStack<>();

        // push
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack); // -> [1,2,3]

        // pop
        stack.exPop();
        System.out.println(stack); // -> [1,2]
        stack.exPop();
        System.out.println(stack); // -> [1]


    }

}