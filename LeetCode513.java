public class LeetCode513 {
    //1.最长子序列问题LCS
    public int minDistance(String word1, String word2) {
        char[] char1 = word1.toCharArray(), char2 = word2.toCharArray();
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 假定存在哨兵空格，初始化 f[0][x] 和 f[x][0]
        for (int i = 0; i <= m; i++) {
           dp[i][0] = 0;
        }
        for (int i = 0; i <= n; i++) {
          dp[0][i] = 0;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                if(char1[i - 1] == char2[j - 1]){
                    dp[i][j] = Math.max(dp[i - 1][j - 1] + 1,dp[i][j]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }
}
