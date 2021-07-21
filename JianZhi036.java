import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi036 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        Set<ListNode> set = new HashSet<>();
        while (a != null) {
            set.add(a);
            a = a.next;
        }
        while (b != null && !set.contains(b)) b = b.next;
        return b;
    }
}
