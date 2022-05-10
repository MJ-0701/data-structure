package ex01;

import org.junit.jupiter.api.Test;


class ArrayTest {

    @Test
    void arrayTest(){
        ArrayClass arrayClass = new ArrayClass();

        arrayClass.arrayList();
    }

    @Test
    void mCountTest(){
        ArrayClass arrayClass = new ArrayClass();
        arrayClass.arrayMcount();
    }

}