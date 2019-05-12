public class LeetCode141 {
    public static class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
  }
    public static boolean hasCycle(ListNode head) {
        ListNode slow,fast;
        slow=fast=head;
        while(slow!=null&&fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)return true;
        }
        return false;
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
        System.out.println(hasCycle(dummyHead));
    }
}
