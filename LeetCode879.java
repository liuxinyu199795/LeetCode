/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode879 {
    //1.动态规划 将每个任务看作一个「物品」，完成任务所需要的人数看作「成本」，完成任务得到的利润看作「价值」。
    //定义 f[i][j][k]f[i][j][k] 为考虑前 ii 件物品，使用人数不超过 jj，所得利润至少为 kk 的方案数。=不选 + 选
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int m = profit.length,mod = (int)1e9+7;
        long[][][] dp = new long[m + 1][n + 1][minProfit + 1];
        for (int i = 0; i <= n; i++) {
            dp[0][i][0] = 1;
        }
        for (int i = 1; i <= m; i++) {
            int a = group[i - 1],b = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];//不选
                    if(j >= a){
                        int u = Math.max(k - b ,0);
                        dp[i][j][k] += dp[i - 1][j - a][u];//加法
                        if(dp[i][j][k] > mod) dp[i][j][k] %= mod;
                    }
                }
            }
        }
        return (int)dp[m][n][minProfit];
    }
}
