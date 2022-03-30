import java.util.*;

public class LeetCode1606 {
    static int N = 100010;
    static int[] cnts = new int[N];
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        Arrays.fill(cnts, 0);
        int n = arrival.length, max = 0;
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b)->a[1]-b[1]);
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) free.add(i);
        for (int i = 0; i < n; i++) {
            int start = arrival[i], end = start + load[i];
            while (!busy.isEmpty() && busy.peek()[1] <= start) free.add(busy.poll()[0]);
            Integer u = free.ceiling(i % k);
            if (u == null) u = free.ceiling(0);
            if (u == null) continue;
            free.remove(u);
            busy.add(new int[]{u, end});
            max = Math.max(max, ++cnts[u]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (cnts[i] == max) ans.add(i);
        }
        return ans;
    }
}
