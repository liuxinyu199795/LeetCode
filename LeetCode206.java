import java.util.List;

public class LeetCode206 {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
  }
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head,pre=null;
        while(cur!=null){
            ListNode listNode=cur.next;
            cur.next=pre;
            pre=cur;
            cur=cur.next;
        }
        return pre.next;
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
        ListNode list = reverseList(dummyHead);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
