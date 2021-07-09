import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode930 {
    //1.前缀和+暴力做法
    public int numSubarraysWithSum(int[] nums, int goal) {
        int length = nums.length;
        int[] sums = new int[length + 1];
        sums[0] = 0;
        for (int i = 1; i <= length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        int res = 0;
        for (int i = 0; i < length ; i++) {
            for (int j = i + 1; j <= length ; j++) {
                if(sums[j]- sums[i] == goal){
                    res++;
                }
            }
        }
        return res;
    }
    //2.前缀和+hash表
    /*public int numSubarraysWithSum(int[] nums, int t) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int r = sum[i + 1], l = r - t;
            ans += map.getOrDefault(l, 0);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return ans;
    }*/

}
