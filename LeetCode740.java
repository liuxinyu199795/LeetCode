/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode740 {
    //动态规划，二维dp数组，第一个是数字大小，第二个是是否取，1代表取，0代表不取
    public int deleteAndEarn(int[] nums) {
        int[] cur  = new int[10009];
        int max = 0;
        for (int num : nums) {
            cur[num]++;
            max = Math.max(max,num);
        }
        int[][] dp = new int[max+1][2];
        for (int i = 1; i <= max; i++) {
            dp[i][1] = dp[i-1][0] + i * cur[i];
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]);
        }
        return Math.max(dp[max][0],dp[max][1]);
    }
}
