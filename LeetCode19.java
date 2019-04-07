package GaoPinSuanFa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode19 {
    //定义指针
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head;
        ListNode q=head;
        while(n-->0){
            p=p.next;//移动指针
        }
        if(p==null){
            return head.next;
        }
        while(p.next!=null){
            p=p.next;
            q=q.next;
        }
        q.next=q.next.next;
        return head;

    }
    public static void main(String[] args) {
        ListNode dummyHead = new ListNode(1);
        ListNode dummyHead1 = new ListNode(2);
        ListNode dummyHead2 = new ListNode(3);
        ListNode dummyHead3 = new ListNode(4);
        ListNode dummyHead4 = new ListNode(5);
        dummyHead.next = dummyHead1;
        dummyHead1.next = dummyHead2;
        dummyHead2.next = dummyHead3;
        dummyHead3.next = dummyHead4;
        ListNode list =removeNthFromEnd(dummyHead,2);
        while(list!=null){
            System.out.println(list.val);
            list=list.next;
        }

    }
}
