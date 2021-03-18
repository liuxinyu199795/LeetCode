public class LeetCode92 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //1.普通法，翻转链表
    /*public ListNode reverseBetween(ListNode head, int m, int n) {
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
    }*/
    //2.双指针，一个pre，将移动的指针的后一个插在pre前面
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode pre = dummy;
        for (int i = 1; i <m ; i++) {
            pre=pre.next;
        }
        head=pre.next;
        for (int i = m; i <n ; i++) {
            ListNode remove = head.next;
            head.next = head.next.next;
            remove.next=pre.next;
            pre.next = remove;
        }
        return dummy.next;
    }
    public static void main(String[] args) {

    }
}
