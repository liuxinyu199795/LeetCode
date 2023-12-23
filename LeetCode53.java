import java.util.Map;

public class LeetCode53 {
    //前缀和，记录下最小的前缀，每个值都跟他的差值进行比较
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE,min = 0,sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            res = Math.max(res,sum - min);//0到当前区间减去其中部分最小区间
            min = Math.min(min,sum);//维护最小区间
        }
        return res;
    }
}
