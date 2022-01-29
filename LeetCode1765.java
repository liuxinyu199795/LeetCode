import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1765 {
    public int[][] highestPeak(int[][] g) {
        int m = g.length, n = g[0].length;
        int[][] ans = new int[m][n];
        Deque<int[]> d = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) d.addLast(new int[]{i, j});
                ans[i][j] = g[i][j] == 1 ? 0 : -1;
            }
        }
        int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
        int h = 1;
        while (!d.isEmpty()) {
            int size = d.size();
            while (size-- > 0) {
                int[] info = d.pollFirst();
                int x = info[0], y = info[1];
                for (int[] di : dirs) {
                    int nx = x + di[0], ny = y + di[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (ans[nx][ny] != -1) continue;
                    ans[nx][ny] = h;
                    d.addLast(new int[]{nx, ny});
                }
            }
            h++;
        }
        return ans;
    }

}
