package cn.scut;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */
public class StackPushAndPop {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {

        int point = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        while (point < popA.length && i <= pushA.length) { // i可以一直移动到最后一个位置, 但这是只是等待popA和站内元素匹配, 如果出现下面匹配失败的情况, 则直接跳出
            if(stack.isEmpty()){  // 栈为空, 入栈后又出栈
                stack.push(pushA[i]);
                i ++;
            }
            if (stack.peek() == popA[point]) {
                stack.pop();
                point++;
            } else {
                if(i >= pushA.length){
                    break;
                }
                stack.push(pushA[i]);
                i++;
            }
        }



        if(stack.empty()){
            return true;
        }else {
            return false;
        }

    }


    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
//        int[] popA = {4, 5, 3, 2, 1};
        int[] popA = {1, 2, 3, 4, 5};

        System.out.println(IsPopOrder(pushA, popA));
    }
}
