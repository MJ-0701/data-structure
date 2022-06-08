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

    // 삭제
    public boolean delete(int value){
        boolean searched = false;
        Node currParentNode = this.head;
        Node currNode = this.head;

        // 코너 케이스(예외 케이스)1: Node가 하나도 없을때.
        if(this.head == null){ // Node 가 없다라는 것은 head 또한 없다는 것.
            return false;

        }
        // 코너 케이스2 : Node가 단지 하나만 있고, 해당 Node가 삭제할 Node 일때,
        else{
            if(this.head.value == value && this.head.left == null && this.head.right == null){
                this.head = null;
                return true;
            }
            while(currNode != null){
                if(currNode.value == value){
                    searched = true;
                    break;
                }else if(value < currNode.value){
                    currParentNode = currNode;
                    currNode = currNode.left;

                }else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }
            if(searched == false){
                return  false;
            }
        }
        // 여기까지 실행 되면,
        // currNode 에는 해당 데이터를 가지고 있는 Node,
        // currParentNode 에는 해당 데이터를 가지고 있는 Node 의 부모 Node

        // case 1 : 삭제 할 Node가 Leaf Node 인 경우
        if(currNode.left == null && currNode.right == null){
            if(value < currParentNode.value){
                currParentNode.left = null; // -> 현재 왼쪽의 Leaf Node 를 null 로 변경
                currNode = null; // 안써도 되지만 좀더 명시적으로 보이게 하기 위하여.
            }else{
                currParentNode.right = null;
                currNode = null;
            }
            return true;
        }
        // Case2-1: 삭제할 Node 가 Child Node를 한 개 가지고 있을 경우
        else if(currNode.left != null && currNode.right == null){ // (왼쪽에 Child Node 가 있을 경우)
            if(value < currParentNode.value){ // 삭제 해야될 Node가 부모 Node 보다 작으면 왼쪽에 있다.
                currParentNode.left = currNode.left; // 현재 삭제해야될 Node 의 자식 Node 를 Parent Node의 Left로 변경.
                currNode = null;

            }else{ // 그렇지 않을땐 오른쪽에 있다.
                currParentNode.right = currNode.left;
                currNode = null;
            }
            return true;
        }
        // Case2-2: 삭제할 Node 가 Child Node를 한 개 가지고 있을 경우
        else if(currNode.left == null && currNode.right != null){ // (오른쪽에 Child Node 가 있을 경우)
            if(value < currParentNode.value){
                currParentNode.left = currNode.right;
                currNode = null;
            }else {
                currParentNode.right = currNode.right;
                currNode = null;
            }
            return true;
        }
        else {
            // 삭제할 Node가 Child Node를 두 개 가지고 있을 경우(삭제할 Node가 Parent Node 왼쪽에 있을때)
            // 기본 사용전략 : 밑의 전략중 하나를 선택해서 사용 한다.
            // 1.삭제할 Node의 오른쪽 자식 중, 가장 작은 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
            // 2.삭제할 Node의 왼쪽 자식 중, 가장 큰 값을 삭제할 Node의 Parent Node가 가리키도록 한다.
            // 1번전략 사용
            // Case3-1: 삭제할 Node 가 Child Node 를 두 개 가지고 있고, (삭제할 Node 가 부모 Node 의 왼쪽에 있을 때)

            if(value < currParentNode.value){ // 삭제할 Node 가 부모 Node 의 왼쪽에 있을 때
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while(changeNode.left != null){
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;

                }
                // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 Node 중에서,
                // 가장 작은 값을 가진 Node 가 들어있음


                if(changeNode.right != null){ // Case 3-1-2: angeNode 의 오른쪽 child Node 가 있을 때.
                    changeParentNode.left = changeNode.right;
                }else { // Case 3-1-1: changeNode 의 child Node 가 없을 때.
                    changeParentNode.left = null;
                }
                // currParentNode 의 왼쪽 Child Node 에, 삭제할 Node 의 오른쪽 자식중,
                // 가장 작은 값을 가진 changeNode 를 연결
                currParentNode.left = changeNode;

                // currParentNode 의 왼쪽 Child Node 가 현재 changeNode 이고
                // changeNode 의 왼쪽/오른쪽 Child Node 를 모두, 삭제할 currNode 의
                // 기존 왼쪽/오른쪽 Node 로 변경.
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

                currNode = null;

            } else { // Case3-2: 삭제할 Node 가 Child Node 를 두 개 가지고 있고, (삭제할 Node 가 부모 Node 의 오른쪽에 있을 때)
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode = changeNode.left;
                }
                // 여기까지 실행되면, changeNode 에는 삭제할 Node 의 오른쪽 Node 중에서,
                // 가장 작은 값을 가진 Node 가 들어있음
                if (changeNode.right != null) {
                    // Case 3-2-2: changeNode 의 오른쪽 Child Node 가 있을 때
                    changeParentNode.left = changeNode.right;
                } else {
                    // Case 3-2-1: changeNode 의 Child Node 가 없을 때
                    changeParentNode.left = null;
                }
                // currParentNode 의 오른쪽 Child Node 에, 삭제할 Node 의 오른쪽 자식중,
                // 가장 작은 값을 가진 changeNode 를 연결
                currParentNode.right = changeNode;

                // parentNode 의 왼쪽 Child Node 가 현재, changeNode 이고,
                // changeNode 의 왼쪽/오른쪽 Child Node 를 모두, 삭제할 currNode 의
                // 기존 왼쪽/오른쪽 Node 로 변경
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;

                currNode = null;

            }
            return true;
        }
    }



}
