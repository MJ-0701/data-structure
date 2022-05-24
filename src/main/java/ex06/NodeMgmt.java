package ex06;

public class NodeMgmt { // 이진 탐색트리 구현
    Node head = null;

    public class Node{
        Node left;
        Node right;
        int value;
        public Node(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }
    }

    public boolean insertData(int data){
        // case1 : Node 가 하나도 없을때.
        if(this.head == null){
            this.head = new Node(data);
        }else{ // case2 : Node 가 하나 이상 있을때.
            Node findNode = this.head;
            while (true){
                // case2-1 : 현재 Node의 왼쪽에 Node가 들어가야 할 때.
                if(data < findNode.value){
                    if(findNode.left != null){
                        findNode = findNode.left;
                    }else{
                        findNode.left = new Node(data);
                        break;
                    }
                }else{ // case2-2 : 현재 Node의 오른쪽에 Node가 들어가야 할 때.
                    if(findNode.right != null){
                        findNode = findNode.right;
                    }else{
                        findNode.right = new Node(data);
                        break;
                    }
                }
            }
        }
        return true;

    }

    // 탐색
    public Node search(int data){
        // case1 : Node 가 존재하지 않을때.
        if(this.head == null){
            return null;
        }else{ // case2 : Node 가 존재 할 때.
            Node findNode = this.head; // root node
            while(findNode != null){
                if(findNode.value == data){
                    return findNode;
                }else if(data < findNode.value){
                    findNode = findNode.left;
                }else {
                    findNode = findNode.right;
                }
            }
            return null;
        }

    }


}
