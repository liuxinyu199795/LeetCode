public class Jianz042 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int[] dp = new int[array.length];
        int max = array[0];
        dp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i],array[i]);//必须连续，不能分开，要么只算当前的
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
