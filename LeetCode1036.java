import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class LeetCode1036 {
    int EDGE = (int)1e6, MAX = (int)1e5;
    Set<String> set = new HashSet<>();
    int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    public boolean isEscapePossible(int[][] blocked, int[] s, int[] t) {
        for (int[] p : blocked) set.add(p[0] + "_" + p[1]);
        int n = blocked.length;
        MAX = n * (n - 1) / 2; // 字符串拼接的哈希方式常数较大，不能直接用 1e5
        return check(s, t) && check(t, s);
    }
    boolean check(int[] a, int[] b) {
        Set<String> vis = new HashSet<>();
        Deque<int[]> d = new ArrayDeque<>();
        d.addLast(a);
        vis.add(a[0] + "_" + a[1]);
        while (!d.isEmpty() && vis.size() <= MAX) {
            int[] poll = d.pollFirst();
            int x = poll[0], y = poll[1];
            if (x == b[0] && y == b[1]) return true;
            for (int[] di : dir) {
                int nx = x + di[0], ny = y + di[1];
                if (nx < 0 || nx >= EDGE || ny < 0 || ny >= EDGE) continue;
                if (set.contains(nx + "_" + ny)) continue;
                if (vis.contains(nx + "_" + ny)) continue;
                d.addLast(new int[]{nx, ny});
                vis.add(nx + "_" + ny);
            }
        }
        return vis.size() > MAX;
    }
}
