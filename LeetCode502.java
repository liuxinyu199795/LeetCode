import java.util.*;

public class LeetCode502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int length = profits.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(new int[]{capital[i],profits[i]});
        }
        Collections.sort(list,(a,b) -> a[0] - b[0]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        int i = 0;
        while(k-- > 0){
            while(i < length && list.get(i)[0] <= w) q.add(list.get(i++)[1]);
            if(q.isEmpty()) break;
            w += q.poll();
        }
        return w;
    }
}
