public class LeetCode152 {
    /*//1.取巧
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1; //一个保存最大的，一个保存最小的。
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ int tmp = imax; imax = imin; imin = tmp;} //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }*/
    //2.递归
    /*int res;
    public int maxProduct(int[] nums) {
        if(nums.length == 0 || nums==null) return 0;
        res = nums[0];
        dfs(nums,0,nums[0]);
        return res;
    }
    public void dfs(int[] nums,int i,int value){
        if(i>=nums.length-1){
            res = Math.max(res,value);
            return;
        }
        res = Math.max(res,value);
        dfs(nums,i+1,value*nums[i+1]);
        dfs(nums,i+1,nums[i+1]);
    }*/
    //3.动态规划DP
    public int maxProduct(int[] nums) {
        if(nums.length == 0 || nums==null) return 0;
        int[][] dp = new int[nums.length][2];
        dp[0][0]= nums[0];
        dp[0][1]= nums[0];
        int res = nums[0];
        for (int i = 1; i <nums.length ; i++) {
            dp[i][0] = Math.max(Math.max(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]),nums[i]);//求出最大值（从0到i的一段）
            dp[i][1] = Math.min(Math.min(dp[i-1][0]*nums[i],dp[i-1][1]*nums[i]),nums[i]);//求出最小值（从0到i的一段）
            res = Math.max(res,dp[i][0]);
        }
        return res;
    }
    public static void main(String[] args) {
    }
}
