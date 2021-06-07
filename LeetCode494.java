/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode494 {
    //1.DFS深度优先搜索
    int res = 0;
    /*public int findTargetSumWays(int[] nums, int target) {
        dfs(nums,0,0,target);
        return res;
    }
    public void dfs(int[] nums,int cur,int left,int target){
        if(left == nums.length){
            if(cur == target) res++;
            return;
        }
        dfs(nums,cur + nums[left],left + 1,target);
        dfs(nums,cur - nums[left],left + 1,target);
    }*/
    //2.动态规划dp 因为由正负 所以要向右考虑偏移sum个单位
    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length, sum = 0;
        for (int num : nums) {
            sum += Math.abs(num);
        }
        if(target > sum) return 0;
        int[][] dp = new int[length + 1][2 * sum + 1];
        dp[0][0 + sum] = 1;
        for (int i = 1; i <= length; i++) {
            int x = nums[i - 1];
            for (int j = -sum; j <= sum; j++) {
                if(j - x + sum >= 0) dp[i][j + sum] += dp[i - 1][j - x + sum];
                if(j + x + sum <= 2 * sum) dp[i][j + sum] += dp[i - 1][j + x + sum];
            }
        }
        return dp[length][target + sum];
    }
}
