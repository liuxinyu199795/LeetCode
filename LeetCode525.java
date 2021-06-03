import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode525 {
    //1.最大前缀和+hash
    public static int findMaxLength(int[] nums) {
        int length = nums.length;
        int[] sum = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            sum[i] = sum[i-1] + (nums[i-1] == 1 ? 1 : -1);//-1来代替0
        }
        int res = 0;
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 2; i <= length; i++) {
            if(!hashMap.containsKey(sum[i-2])) hashMap.put(sum[i-2],i-2);
            if(hashMap.containsKey(sum[i])) res = Math.max(res,i - hashMap.get(sum[i]));//如果相同则说明为0，满足要求求出最大长度
        }
        return res;
    }

}
