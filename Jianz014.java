public class Jianz014 {
    public int cutRope(int target) {
        int[] dp = new int[target + 1];
        dp[1] = 1;
        for (int i = 2; i <= target ; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i],Math.max(j,dp[j]) * Math.max(i - j,dp[i - j]));
            }
        }
        return dp[target];
    }
}
