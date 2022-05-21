package ex05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearHashTableTest {


    @Test
    void linearHashtableTest(){
        LinearHashTable hashTable = new LinearHashTable(20);

        hashTable.saveData("jack", "01077603932");
        hashTable.saveData("jason", "01011112222");
        hashTable.saveData("json", "01022223333");

        System.out.println(hashTable.getData("json"));
    }

}