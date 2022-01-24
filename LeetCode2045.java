import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode2045 {
    static int N = 10010, M = 4 * N, INF = 0x3f3f3f3f, idx = 0;
    static int[] he = new int[N], e = new int[M], ne = new int[M];
    static int[] dist1 = new int[N], dist2 = new int[N];
    void add(int a, int b) {
        e[idx] = b;
        ne[idx] = he[a];
        he[a] = idx;
        idx++;
    }
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Arrays.fill(dist1, INF);
        Arrays.fill(dist2, INF);
        Arrays.fill(he, -1);
        idx = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            add(u, v); add(v, u);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->a[1]-b[1]);
        q.add(new int[]{1, 0});
        dist1[1] = 0;
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int u = poll[0], step = poll[1];
            for (int i = he[u]; i != -1; i = ne[i]) {
                int j = e[i];
                int a = step / change, b = step % change;
                int wait = a % 2 == 0 ? 0 : change - b;
                int dist = step + time + wait;
                if (dist1[j] > dist) {
                    dist2[j] = dist1[j];
                    dist1[j] = dist;
                    q.add(new int[]{j, dist1[j]});
                    q.add(new int[]{j, dist2[j]});
                } else if (dist1[j] < dist && dist < dist2[j]) {
                    dist2[j] = dist;
                    q.add(new int[]{j, dist2[j]});
                }
            }
        }
        return dist2[n];
    }

}
