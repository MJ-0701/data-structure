package ex01;

import java.util.LinkedList;
import java.util.Queue;

public class QueueClass { // First In First Out


    public void queueLinkedList(){
        Queue<Integer> queue_int = new LinkedList<Integer>();
        Queue<String> queue_str = new LinkedList<String>();

        queue_int.add(1); // 자바에서는 enqueue 기능을 add 메소드 로 제공한다.
        queue_int.offer(2); // offer 로도 사용 가능 -> 단, offer 는 boolean 타입이므로 성공적으로 파라미터를 추가하게 되면 true 를 반환, 실제 값은 따로 가져 와야함.
        // System.out.println(queue_int.offer(2)); // true

        System.out.println(queue_int); // -> [1,2]

        queue_int.poll(); // dequeue -> 큐 데이터의 제일 앞의값을 꺼내오고 해당 값은 삭제한다.
        System.out.println(queue_int); // -> [2]

        queue_int.remove(); // remove 또 한 dequeue 기능을 제공한다.
        System.out.println(queue_int); // -> []

    }
}
