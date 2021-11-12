public class LeetCode375 {
    //1.递归+记忆化
    /*static int N = 210;
    static int[][] cache = new int[N][N];
    public int getMoneyAmount(int n) {
        return dfs(1,n);
    }
    public int dfs(int l,int r){
        if(l >= r) return 0;
        if(cache[l][r] != 0) return cache[l][r];
        int ans = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            int cur = Math.max(dfs(l,i-1),dfs(i+1,r)) + i;
            ans = Math.min(ans,cur);
        }
        cache[l][r] = ans;
        return ans;
    }*/
    //2.序列DP
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 10][n + 10];
        for (int len = 2; len <= n; len++) {//长度
            for (int l = 1; l + len - 1 <= n; l++) {//左边
                int r = l + len - 1;
                dp[l][r] = Integer.MAX_VALUE;
                for (int i = l; i <= r; i++) {//中间
                    int cur = Math.max(dp[l][i - 1],dp[i + 1][r]) + i;
                    dp[l][r] = Math.min(dp[l][r],cur);
                }
            }
        }
        return dp[1][n];
    }
}
