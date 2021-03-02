/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode303 {
    /*//1.暴力求解
    int[] array;
    public NumArray(int[] nums) {
        this.array = nums;
    }

    public int sumRange(int i, int j) {
        if(i>j) return 0;
        int sum =0;
        for (int k = i; k <=j ; k++) {
            sum+=array[k];
        }
        return sum;
    }
    //2.动态规划
    private int[] dp;
    public NumArray(int[] nums) {
        if(nums.length<=0||nums==null) return;
        dp = new int[nums.length];
        dp[0]= nums[0];
        for (int i = 1; i <nums.length ; i++) {
            dp[i]=dp[i-1]+nums[i];
        }
    }

    public int sumRange1(int i, int j) {
        return i==0?dp[j]:dp[j]-dp[i-1];
    }*/
}
