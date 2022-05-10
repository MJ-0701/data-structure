package ex01;

import java.util.ArrayList;

public class MyQueue<T> { // Queue 직접 구현

    private ArrayList<T> queue = new ArrayList<T>();

    public void enqueue(T item){
        queue.add(item);
    }

    public T dequeue(){
        if(queue.isEmpty()){
            return null;
        }
        return queue.remove(0);
    }
}
