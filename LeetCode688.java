import java.util.Arrays;

public class LeetCode688 {
    //1.记忆化dfs，用数组来记录
    /*int[][] dirs = new int[][]{{-2,-1},{-1,-2},{-1,2},{-2,1},{1,2},{2,1},{1,-2},{2,-1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] memo = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j],-1);
            }
        }return dfs(row, column, k,n,memo);
    }
    public double dfs(int row,int column,int k,int n,double[][][] memo){
        if(row < 0 || column < 0 || row >= n || column >= n) return 0.0;
        if(k == 0) return 1.0;
        if(memo[row][column][k] != -1) return memo[row][column][k];
        double res = 0;
        for (int[] dir : dirs){
            res += dfs(row + dir[0],column + dir[1], k - 1,n,memo);
        }
        memo[row][column][k] = res / 8.0;
        return memo[row][column][k];
    }*/
    //2.dp求解
    int[][] dirs = new int[][]{{-1,-2},{-1,2},{1,-2},{1,2},{-2,1},{-2,-1},{2,1},{2,-1}};
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] f = new double[n][n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][0] = 1;
            }
        }
        for (int p = 1; p <= k; p++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] d : dirs) {
                        int nx = i + d[0], ny = j + d[1];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                        f[i][j][p] += f[nx][ny][p - 1] / 8;
                    }
                }
            }
        }
        return f[row][column][k];
    }
}
