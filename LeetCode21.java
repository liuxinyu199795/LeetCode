

import java.util.Stack;

public class LeetCode21 {
    //定义指针
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        //定义新的链表的头结点
        ListNode newList = new ListNode(0);
        //定义一个新链表的头指针
        ListNode cur =newList;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                cur=cur.next;
                l1=l1.next;
            }else{
                cur.next=l2;
                cur=cur.next;
                l2=l2.next;
            }
        }
        if(l1==null){
            cur.next=l2;
        }else{
            cur.next=l1;
        }
        return newList.next;//newList开头有个多余的0，所以返回newList.next
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
        ListNode dummyHed = new ListNode(1);
        ListNode dummyHed1 = new ListNode(2);
        ListNode dummyHed2 = new ListNode(3);
        ListNode dummyHed3 = new ListNode(4);
        ListNode dummyHed4 = new ListNode(5);
        dummyHed.next = dummyHed1;
        dummyHed1.next = dummyHed2;
        dummyHed2.next = dummyHed3;
        dummyHed3.next = dummyHed4;
        ListNode list = mergeTwoLists(dummyHead, dummyHed);
        while(list!=null){
            System.out.println(list.val);
            list=list.next;
        }
    }
}
