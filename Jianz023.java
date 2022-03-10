import java.util.HashSet;
import java.util.Set;

public class Jianz023 {
    public class ListNode {
        int val;
        ListNode next = null;
        public ListNode(int val) {
            this.val = val;
        }
    }
    //1.Set判重法
    /*public ListNode EntryNodeOfLoop(ListNode pHead) {
        Set<Integer> set = new HashSet<>();
        while(pHead != null){
            if(set.contains(pHead.val)) return pHead;
            set.add(pHead.val);
            pHead = pHead.next;
        }
        return null;
    }*/
    //2.双指针法
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(true){
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        fast = pHead;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
