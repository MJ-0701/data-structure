package ex05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainingHashtableTest {

    @Test
    void chainingHashTest(){
        ChainingHashtable hashtable = new ChainingHashtable(20);

        hashtable.saveData("jack", "01077603932");
        hashtable.saveData("jason", "01011112222");
        hashtable.saveData("json", "01022223333");
        System.out.println(hashtable.getData("json"));
    }

}