import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1984 {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int length = nums.length;
        if(length == k && length == 1) return 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < length - k + 1; i++) {
            int tmp = nums[i + k - 1] - nums[i];
            min = Math.min(min,tmp);
        }
        return min;
    }
}
