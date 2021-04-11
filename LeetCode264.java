import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode264 {
    //1.优先队列（小根堆），把最小值的2，3，5倍放入队列，用set去重
    /*public int nthUglyNumber(int n) {
        if(n==1) return 1;
        int[] nums = new int[]{2,3,5};
        Set<Long> set = new HashSet<>();
        Queue<Long> queue = new PriorityQueue<>();
        set.add(1L);
        queue.add(1L);
        for (int i = 1; i <=n ; i++) {
            if(i==n) return queue.peek().intValue();
            Long q = queue.poll();
            for (int num : nums) {
                Long p = q * num;
                if(!set.contains(p)){
                    set.add(p);
                    queue.add(p);
                }
            }
        }
        return -1;
    }*/
    //2.三指针法
    public int nthUglyNumber(int n) {
        int[] res = new int[n+1];
        res[1] = 1;
        for (int i = 1,j = 1,k = 1,idx = 2; idx <=n ; idx++) {
            int o = res[i] * 2;
            int p = res[j] * 3;
            int q = res[k] * 5;
            int min = Math.min(o,Math.min(p,q));
            if(o==min) i++;
            if(p==min) j++;
            if(q==min) k++;
            res[idx] = min;
        }
        return res[n];
    }
}
