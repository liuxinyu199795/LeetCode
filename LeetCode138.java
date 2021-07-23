import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode138 {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    //1.先按照普通排序，最后遍历这两个处理random指针
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node dummy = new Node(-1);
        Node tail = dummy,tmp = head;
        while(tmp != null){
            Node node = new Node(tmp.val);
            map.put(tmp,node);
            tail.next = node;
            tail = tail.next;
            tmp = tmp.next;
        }
        tail = dummy.next;
        while(head != null){
            if(head.random != null) tail.random = map.get(head.random);
            tail = tail.next;
            head = head.next;
        }
        return dummy.next;
    }
}
