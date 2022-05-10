package ex02;

import java.util.ArrayList;

public class MyStack<T> {

    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item){
        stack.add(item);
    }

    // 내가 짠 코드
    public T pop(T item){ // 잘못된점 : pop 함수는 파라미터를 받지 않음.
        if(stack.isEmpty()){
            return null;
        }
        return stack.remove(stack.lastIndexOf(item)); // lastIndexOf 메소드를 잘못 이해하고 있엇음. lastIndexOf 메소드는 뒤에서부터 문자열을 탐색하여 해당 문자의 위치를 찾아주는 기능.
        // 해당 값이 없으면 -1을 리턴
    }

    // 예제 코드
    public T exPop(){
        if(stack.isEmpty()){
            return null;
        }

        return stack.remove(stack.size() -1); // 스택의 사이즈 함수를 이용하여 사이즈값을 구하고 -1을 하여(0~9 -> 크기 :10 -> 10 -1 : 9번인덱스 리턴) 실제 마지막 인덱스 번호를 리턴
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "stack=" + stack +
                '}';
    }
}
