import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode212 {
    //1.回溯（需要用vis数组判断是否经过，方向数组dirs来循环，出来要还原vis和sb字符串）
    Set<String> set = new HashSet<>();
    List<String> ans =new ArrayList<>();
    char[][] board;
    int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int n,m;
    boolean[][] vis = new boolean[15][15];
    public List<String> findWords(char[][] _board, String[] words) {
        board = _board;
        m = board.length; n = board[0].length;
        for (String w : words) set.add(w);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vis[i][j] = true;
                sb.append(board[i][j]);
                dfs(i,j,sb);
                vis[i][j] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return ans;
    }
    void dfs(int i,int j,StringBuilder b){
        if(b.length() > 10) return;
        if(set.contains(b.toString())){
            ans.add(b.toString());
            set.remove(b.toString());
        }
        for (int[] d : dirs) {
            int dx = i + d[0],dy = j + d[1];
            if(dx < 0 || dx >= m || dy < 0 || dy >= n) continue;//越界下一个
            if(vis[dx][dy]) continue;//浏览过的下一个
            vis[dx][dy] = true;
            b.append(board[dx][dy]);
            dfs(dx,dy,b);
            vis[dx][dy] = false;
            b.deleteCharAt(b.length() - 1);
        }
    }
}
