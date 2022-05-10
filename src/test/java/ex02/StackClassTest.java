package ex02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackClassTest {

    @Test
    void stackTest(){

        StackClass stackClass = new StackClass();
        // push
        stackClass.pushStack();

        // pop
        stackClass.popStack();


    }

}