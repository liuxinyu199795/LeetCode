import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class MianShi1710 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) > n / 2) return x;
        }
        return -1;
    }
}
