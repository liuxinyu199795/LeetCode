import java.util.HashMap;

public class Jianz035 {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) return null;
        RandomListNode newHead = new RandomListNode(pHead.label);
        RandomListNode tmp = newHead;
        RandomListNode next = pHead.next;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        map.put(pHead,newHead);
        while(next != null){
            RandomListNode tnext = new RandomListNode(next.label);
            map.put(next,tnext);
            tmp.next = tnext;
            next = next.next;
            tmp = tmp.next;
        }
        tmp = newHead;
        while(tmp != null){
            tmp.random = map.get(pHead.random);
            tmp = tmp.next;
            pHead = pHead.next;
        }
        return newHead;
    }
}
