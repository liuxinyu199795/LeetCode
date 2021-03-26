/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode83 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode dammy  = new ListNode(Integer.MIN_VALUE);
        dammy.next = head;
        ListNode tail = dammy;
        while(head!=null){
            if(tail.val != head.val){
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }
        tail.next =null;
        return dammy.next;
    }
}
