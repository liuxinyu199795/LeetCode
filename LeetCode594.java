import java.util.Arrays;

public class LeetCode594 {
    //1.排序+滑动窗口
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0,j = 0; j < nums.length; j++) {
            while(i < j && nums[j] - nums[i] > 1) i++;
            if(nums[j] - nums[i] == 1) ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}
