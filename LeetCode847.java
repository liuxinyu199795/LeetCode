import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode847 {
    int INF = Integer.MAX_VALUE;
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;
        //state为经过的点（状态压缩，二进制位表示），u表示最后一个点是
        int[][] dist = new int[mask][n];
        //全部初始化为距离（state,u)为最大值
        for (int i = 0; i < mask; i++) {
            Arrays.fill(dist[i],INF);
        }
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dist[1 << i][i] = 0;//初始化距离，扔进队列中BFS
            deque.addLast(new int[]{1 << i,i});
        }
        int res = Integer.MAX_VALUE;
        while(!deque.isEmpty()){
            int[] node = deque.pollFirst();
            int state = node[0],u = node[1],step = dist[state][u];
            if(state == mask - 1){
                res = Math.min(res,step);
            }
            for(int i : graph[u]){
                int newState = state | 1 << i;//在第i-1位上置为1(其他位由于或0还是原来的值)
                if(dist[newState][i] == INF){
                    dist[newState][i] = step + 1;
                    deque.add(new int[]{newState,i});
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
