import java.util.HashSet;
import java.util.Set;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode523 {
    //1.前缀和，要使得两者除k相减为整数，需要满足sum[j]和sum[i-1]对k取余相同
    public boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        int[] sum = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= length; i++) {
            set.add(sum[i-2] % k);
            if(set.contains(sum[i] % k)) return true;
        }
        return false;
    }
}
