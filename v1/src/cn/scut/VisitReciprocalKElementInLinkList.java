package cn.scut;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * 弄两个指针, 让第一个指针先走k-1步,然后两个指针一起走, 当先走的指针到达链表尾的时候, 另一个指针在倒数k的位置
 *
 */
public class VisitReciprocalKElementInLinkList {


    public ListNode FindKthToTail(ListNode head, int k) {

        if (head == null || k == 0) {
            return null;
        }
        ListNode p1 = head;
        ListNode p2 = head;

        int count = 0;

        while (p1.next != null) {
            p1 = p1.next;
            count++;

            if (count >= k) {
                p2 = p2.next;
            }
        }


        if (count + 1 < k) {
            return null;
        }


        return p2;
    }
}
