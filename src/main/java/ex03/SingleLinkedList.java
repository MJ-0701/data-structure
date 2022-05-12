package ex03;

import java.util.Date;



public class SingleLinkedList<T> {

    public Node<T> head = null;

    public class Node<T> {
        T data;
        Node<T> next = null;

        public Node(T data){
            this.data = data;
        }

    }

    public void addNode(T data){
        if(head == null){
            head = new Node<T>(data);
        }
        else{
            Node<T> node = this.head;
            while(node.next != null){ // 가장 최근에 추가된 노드를 가르키게 하는 와일구문
                node = node.next;
            }
            node.next = new Node<T>(data); // 현재 추가된 노드를 마지막으로 보내는 구문
        }
    }

    public void printAll(){
        if(head != null){
            Node<T> node = this.head;
            System.out.println(node.data);
            while(node.next != null){
                node = node.next;
                System.out.println(node.data);
            }
        }
    }

    public Node<T> search(T data){
        if(this.head == null){
            return null;
        }else{
            Node<T> node = this.head;
            while (node != null){
                if(node.data == data){
                    return node;
                }else{
                    node = node.next;
                }
            }
            return null;
        }
    }

    public void addNodeInside(T data, T isData){
        Node<T> searchedNode = this.search(isData);

        if(searchedNode == null){
            this.addNode(data);
        }else{
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<T>(data); // 중간에 낀(새로 넣은 노드의 주소를 가르켜야 됨)
            searchedNode.next.next = nextNode; // 기존에 가르키던 주소는 뒤로 밀렸으므로 가운데 낀 노드의 포인터 값이 돼야함.
        }
    }

    public boolean delNode(T isData){
        if(head == null){
            return false;
        }else{
            Node<T> node = this.head;
            if(node.data == isData){
                this.head = this.head.next;
                return true;
            }else{
                while(node.next != null){
                    if(node.next.data == isData){
                        node.next = node.next.next; // 노드를 삭제하게 되면 그 다음 노드를 가르키도록 하는 코드.( 1->3 2x)
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }
}
