import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode160 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
   //1.链表法，先走A，走完再走B，另一个同理，相遇的地方则为交点
    /*public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }*/
    //2.栈顶法，压入两个栈，然后分别出栈，如果栈顶元素不相同了，则是上一个栈顶元素
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        Deque<ListNode> d1 = new ArrayDeque(), d2 = new ArrayDeque();
        while (a != null) {
            d1.addLast(a);
            a = a.next;
        }
        while (b != null) {
            d2.addLast(b);
            b = b.next;
        }
        ListNode ans = null;
        while (!d1.isEmpty() && !d2.isEmpty() && d1.peekLast().equals(d2.peekLast())) {
            ListNode c1 = d1.pollLast(), c2 = d2.pollLast();
            ans = c1;
        }
        return ans;
    }
}
