package cn.scut;

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class TwoStack2Queue {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int ret = stack2.pop();

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
