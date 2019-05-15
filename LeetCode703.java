import java.util.PriorityQueue;
import java.util.Stack;

public class LeetCode703 {
    static PriorityQueue<Integer> queue;
    static int k;
    public LeetCode703(int k, int[] nums) {
        this.k=k;
        queue = new PriorityQueue<>();
        for (int i:nums) {
            add(i);
        }
    }

    public static int add(int val) {
        if(queue.size()<k){
            queue.offer(val);
        }else{
            if(queue.peek()<val){
                queue.poll();
                queue.offer(val);
            }
        }
        return queue.peek();
    }
    public static void main(String[] args) {

    }
}
