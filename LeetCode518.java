/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode518 {
    //1.完全背包，可以选很多个，要遍历去判断
    public int change(int amount, int[] coins) {
        int length = coins.length;
        int[][] dp = new int[length + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= length; i++) {
            int c = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k * c <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * c];
                }
            }
        }
        return dp[length][amount];
    }
}
