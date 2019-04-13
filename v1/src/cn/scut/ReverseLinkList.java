package cn.scut;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ReverseLinkList {


    // 16ms
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }

        int len = list.size();

        for (int i = 0; i < len / 2; i++) {
            int tmp = list.get(i);
            list.set(i, list.get(len - 1 - i));
            list.set(len - 1 - i, tmp);
        }

        return list;
    }


    public static ArrayList<Integer> printListFromTailToHead_v2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        int len = stack.size();

        while (!stack.isEmpty()){
            list.add(stack.pop());
        }


        return list;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ArrayList<Integer> list = printListFromTailToHead_v2(node1);


        System.out.println(list);

    }
}
