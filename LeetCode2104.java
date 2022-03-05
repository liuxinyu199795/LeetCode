public class LeetCode2104 {
    //1.序列DP
    /*public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n][n][2];
        //初始化数组
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = dp[i][i][1] = nums[i];
        }
        for (int len = 2; len <= n; len++) {
            for (int l = 0;  l + len - 1 < n; l++) {
                int r = l + len - 1;
                dp[l][r][0] = Math.min(dp[l][r - 1][0],nums[r]);
                dp[l][r][1] = Math.max(dp[l][r - 1][1],nums[r]);
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                res += dp[i][j][1] - dp[i][j][0];
            }
        }
        return res;
    }*/
    //2.枚举
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int min = nums[i],max = nums[i];
            for (int j = i + 1; j < n; j++) {
                min = Math.min(min,nums[j]);
                max = Math.max(max,nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }

}
