public class LeetCode2016 {
    public int maximumDifference(int[] nums) {
        int n = nums.length,res = -1,min = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i] > min) res = Math.max(res,nums[i] - min);
            min = Math.min(min,nums[i]);
        }
        return res;
    }
}
