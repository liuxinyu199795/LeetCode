import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode279 {
    //1.动态规划，完全01背包问题，
    int INF = 0x3f3f3f3f;
    public int numSquares(int n) {
        int length = (int)Math.sqrt(n);
        int[][] dp = new int[length + 1][n + 1];
        Arrays.fill(dp[0], INF);
        dp[0][0] = 0;
        for (int i = 1; i <= length; i++) {
            int c = i * i;
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];//不取
                for (int k = 0; k * c <= j; k++) {
                    if (dp[i - 1][j - k * c] != INF) {
                        dp[i][j] = Math.min(dp[i][j],dp[i - 1][j - k * c] + k);
                    }
                }
            }
        }
        return dp[length][n];
    }
}
