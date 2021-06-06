import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi014 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    //1.快慢指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode pre = head;
        int num = 0;
        while(head != null){
            if(num < k){
                head = head.next;
            }else{
                head = head.next;
                pre = pre.next;
            }
            num ++;
        }
        return pre;
    }
    //2.栈
    /*public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode res = null;
        for (int i = 0; i < k; i++) {
            res = stack.pop();
        }
        return res;
    }*/
}
