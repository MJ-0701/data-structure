package ex05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashTableTest {


    @Test
    void hashFunctionTest(){
        MyHashTable myHashTable = new MyHashTable(20);

        myHashTable.saveData("jack", "01077603932");
        myHashTable.saveData("mj", "01011112222");
        myHashTable.saveData("wanda", "01022223333");
        System.out.println(myHashTable.getData("jack")); // 01077603932

    }

}