package GaoPinSuanFa;


public class LeetCode24 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode swapPairs(ListNode head) {
        //设立虚拟头结点
        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;

        ListNode prev = dummyhead;
        while(prev.next != null && prev.next.next!=null){
            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;
            ListNode next = prev.next.next.next;

            node2.next = node1;
            node1.next = next;
            prev.next = node2;

            prev = node1;
        }

        return dummyhead.next;
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
        ListNode list = swapPairs(dummyHead);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
