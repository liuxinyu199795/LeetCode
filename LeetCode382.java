import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode382 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    List<Integer> list = new ArrayList<>();
    Random random = new Random(20220116);
    public LeetCode382(ListNode head) {
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }
    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}
