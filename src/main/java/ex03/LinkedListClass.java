package ex03;

public class LinkedListClass {
    // node : 데이터 저장 단위 (데이터 값 + 포인터) 로 구성
    // pointer : 각 노드 안에서, 다음이나 이전 노드이 연결 정보를 가지괴 있는 공간



    public void exNode(){
        Node<Integer> node1 = new Node<Integer>(1);
        Node<Integer> node2 = new Node<Integer>(2);

        node1.next = node2;

        Node head = node1;


    }




}
