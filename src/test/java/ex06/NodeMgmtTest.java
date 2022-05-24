package ex06;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeMgmtTest {

    @Test
    void treeNodeTest(){
        NodeMgmt treeNode = new NodeMgmt();

        treeNode.insertData(1);
        treeNode.insertData(2);
        treeNode.insertData(3);
        treeNode.insertData(4);

        NodeMgmt.Node testNode = treeNode.search(3);
        System.out.println(testNode.value);
//        System.out.println(testNode.left.value); // left 는 현재 데이터들이 오른쪽에만 삽입이 됐으므로 null 이다.
        System.out.println(testNode.right.value);

    }

}