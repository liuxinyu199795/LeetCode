public class LeetCode430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
    //1.递归(记得prev也要指回去)
    public Node flatten(Node head) {
        Node yummy = new Node();
        yummy.next = head;
        while(head != null){
            if(head.child == null){
                head = head.next;
            }else{
                Node tmp = head.next;
                Node child = flatten(head.child);
                head.next = child;
                child.prev = head;
                head.child = null;//把孩子置为空
                while(head.next != null){
                    head = head.next;
                }
                head.next = tmp;
                if(tmp != null){
                    tmp.prev = head;
                }
                head = tmp;
            }
        }
        return yummy.next;
    }
}
