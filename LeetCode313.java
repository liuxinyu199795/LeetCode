import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(n == 1) return 1;
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> queue = new PriorityQueue<>();
        set.add(1l);
        queue.add(1l);
        while(n-- > 0){
            long poll = queue.poll();
            if(n == 0) return (int)poll;
            for (int x : primes) {
                long num = x * poll;
                if(!set.contains(num)){
                    set.add(num);
                    queue.add(num);
                }
            }
        }
        return -1;
    }
}
