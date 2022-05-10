package ex02;

import java.util.ArrayList;
import java.util.Stack;

public class StackClass { // last in First Out

    // push -> 스택에 데이터를 넣는 함수
    // pop -> 스택에서 데이터를 꺼내는 함수

    Stack<Integer> stack = new Stack<Integer>();

    public void pushStack(){
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack); // -> [1,2,3]
    }

    public void popStack(){
        stack.pop();
        System.out.println(stack); // -> [1,2] 가장 나중에 추가된 3이 제거됨.

    }




}
