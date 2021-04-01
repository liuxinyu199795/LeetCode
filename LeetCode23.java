


import java.util.Arrays;

public class LeetCode23 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        if (lists.length == 2) {
            return addLists(lists[0], lists[1]);
        }
        return addLists(lists[0], mergeKLists(Arrays.copyOfRange(lists, 1, lists.length)));
    }
    public static ListNode addLists(ListNode l1,ListNode l2){
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = addLists(l1.next, l2);
            return l1;
        } else {
            l2.next = addLists(l1, l2.next);
            return l2;
        }
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
        ListNode[] str =new ListNode[2];
        str[1]=dummyHead;
        str[2]=dummyHed;
        ListNode list = mergeKLists(str);
        while(list!=null){
            System.out.println(list.val);
            list=list.next;
        }
    }
}
