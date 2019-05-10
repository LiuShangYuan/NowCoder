package cn.scut;
import java.util.Stack;

//定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

public class StackContainMinFunction {


    Stack<Integer> dataStack = new Stack<>();

    Stack<Integer> helpStack = new Stack<>();

    int mind = Integer.MAX_VALUE;

    public void push(int node) {
        dataStack.push(node);
        if(node <= mind){
            helpStack.push(node);
            mind = node;
        }
    }

    public void pop() {
        int popd = dataStack.pop();

        if(popd == mind){
            helpStack.pop();
        }

        mind = helpStack.peek();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return helpStack.peek();
    }

    /**
     * ["PSH3","MIN","PSH4","MIN","PSH2","MIN","PSH3","MIN","POP","MIN","POP","MIN","POP","MIN","PSH0","MIN"
     * @param args
     */

    public static void main(String[] args) {
        StackContainMinFunction sk = new StackContainMinFunction();
        sk.push(3);
        System.out.println(sk.min());
    }

}
