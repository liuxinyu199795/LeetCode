public class LeetCode92 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre = dummy;
        for (int i = 1; i <m ; i++) {
            pre=pre.next;
        }
        head=pre.next;
        for (int i = m; i <n ; i++) {
            ListNode next = head.next;
            head.next=next.next;
            next.next=pre.next;
            pre.next=next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {

    }
}
