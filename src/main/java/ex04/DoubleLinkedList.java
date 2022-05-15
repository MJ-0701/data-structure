package ex04;

import ex03.Node;

public class DoubleLinkedList<T> { // 링크드 리스트의 단점이라고 한다면 100개의 노드가 있다고 가정 하면 99 번쨰 노드이 위치를 찾을떄 99개를 처음부터 다 찾아야 한다는 것임.
    // 해당 기능의 약점을 보완하고자 데이터의 앞뒤에 포인터를 연결해 놓은 것이 더블 링크드 리스트
    // - 이중 연결 리스트라고도 함 / - 양쪽으로 검색이 가능

    public Node<T> head = null;
    public Node<T> tail = null;

    public class Node<T> {
        T data;
        Node<T> prev = null; // 이전 노드의 주소를 알려주는 포인터
        Node<T> next = null; // 다음 노드의 주소를 알려주는 포인터

        public Node(T data) {
            this.data = data;
        }
    }

    public void addNode(T data){
        if(head == null){
            this.head = new Node<T>(data);
            this.tail = this.head;
        }else{
            Node<T> node = this.head;
            while (node.next != null){
                node = node.next;
            }
            node.next = new Node<T>(data);
            node.next.prev = node;
            this.tail = node.next;
        }
    }

    public void printAll(){
        if(this.head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    // 헤드부터 검색 하는 메소드
    public T searchFromHead(T isData){
        if(this.head == null){
            return null;
        }else{
            Node<T> node = this.head;
            while (node != null){
                if(node.data == isData){
                    return node.data;
                }else{
                    node = node.next;
                }
            }
            return null;
        }

    }

    // 테일부터 검색 하는 메소드
    public T searchFromTail(T isData){
        if(head == null){
            return null;
        }else{
            Node<T> node = this.tail;
            while(node != null){
                if(node.data == isData){
                    return node.data;
                }else{
                    node = node.prev;
                }
            }
            return null;
        }
    }
}

