package ex03;

public class SingleLinkedList<T> {

    public Node<T> head = null;

    public class Node<T>{
        T data;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }

    }

    public void addNode(T data){
        if(head == null){
            head = new Node(data);
        }
        else{
            Node<T> node = this.head;
            while(node != null){ // 가장 최근에 추가된 노드를 가르키게 하는 와일구문
                node = node.next;
            }
            node.next = new Node<T>(data); // 현재 추가된 노드를 마지막으로 보내는 구문
        }
    }
}
