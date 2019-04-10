package GaoPinSuanFa;


public class LeetCode25 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode p=head;
        //判断链表长度是否大于K
        for (int i = 0; i <k ; i++) {
            if(p==null){
                return head;
            }else {
                p=p.next;
            }
        }
        //反转链表
        ListNode q=head.next;
        ListNode v=head;
        ListNode w=null;
        for (int i = 0; i <k-1 ; i++) {
            w=q.next;
            q.next=v;
            v=q;
            q=w;
        }
        //开始下一段反转
        head.next=reverseKGroup(q,k);
        return v;
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
        ListNode list = reverseKGroup(dummyHead,2);
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }
}
