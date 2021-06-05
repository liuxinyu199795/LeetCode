import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode203 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public ListNode removeElements(ListNode head, int val) {
        ListNode yammy = new ListNode(-1);
        yammy.next = head;
        ListNode pre = yammy;
        while (head != null){
            ListNode next = head.next;
            if(head.val == val){
                pre.next = next;
                head = head.next;
            }else{
                pre = head;
                head = next;
            }
        }
        return yammy.next;
    }
}
