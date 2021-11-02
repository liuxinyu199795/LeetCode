public class LeetCode237 {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }
   //1.改变当前节点的值等于下个节点的值，然后删除下个节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
