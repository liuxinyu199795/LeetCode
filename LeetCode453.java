public class LeetCode453 {
    //1.n-1个加1 == 1个减1
    public int minMoves(int[] nums) {
        if(nums.length == 1) return 0;
        int min = nums[0],ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < min){ min = nums[i]; }
        }
        for (int num : nums) {
            ans += num - min;
        }
        return ans;
    }
}
