/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode61 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //1.遍历得到长度，然后取余处理
    /*public ListNode rotateRight(ListNode head, int k) {
        if(head ==null || k==0) return head;
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        ListNode dummy = pre;
        pre.next = head;
        ListNode tail = head;
        int length = 0;
        while(tail!=null){
            length++;
            dummy = dummy.next;
            tail = tail.next;
        }
        int reverse = length - k % length;
        while(--reverse!=0){
            head = head.next;
        }
        dummy.next = pre.next;
        pre.next = head.next;
        head.next = null;
        return pre.next;
    }*/
    //闭合成环，找到第k个断开
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        // 先将链表成环，并记录链表的长度
        // tmp 会记录住原链表最后一位节点
        int tot = 0;
        ListNode tmp = head;
        while (tmp.next != null && ++tot > 0) tmp = tmp.next;
        tot++;
        k %= tot;
        if (k == 0) return head;

        // 正式成环
        tmp.next = head;

        // 从原链表 head 出发，走 tot - k - 1 步，找到「新尾结点」进行断开，并将其下一个节点作为新节点返回
        k = tot - k - 1;
        while (k-- > 0) head = head.next;
        ListNode nHead = head.next;
        head.next = null;
        return nHead;
    }
}
