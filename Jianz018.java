public class Jianz018 {
    public class ListNode {
     int val;
     ListNode next = null;
     public ListNode(int val) {
       this.val = val;
     }
   }
    public ListNode deleteNode (ListNode head, int val) {
        if(val == head.val) return head.next;
        // write code here
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode yummy = head;
        while(head.next != null){
            ListNode next = head.next;
            if(val == head.val){
                pre.next = next;
                return yummy;
            }
            pre = pre.next;
            head = next;
        }
        return yummy;
    }
}
