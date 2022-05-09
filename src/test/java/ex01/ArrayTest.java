package ex01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ArrayTest {

    @Test
    void arrayTest(){
        Array array = new Array();

        array.arrayList();
    }

    @Test
    void mCountTest(){
        Array array = new Array();
        array.arrayMcount();
    }

}