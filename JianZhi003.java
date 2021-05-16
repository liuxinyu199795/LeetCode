import java.util.Stack;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi003 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    //1.栈存法，时间复杂度2n
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while(head != null){
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        int i = 0;
        while(!stack.isEmpty()){
            res[i++] = stack.pop();
        }
        return res;
    }
}
