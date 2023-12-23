import java.util.HashMap;
import java.util.Map;

public class LeetCode560 {
    //1.暴力搜索
    /*public static int subarraySum(int[] nums, int k) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = k - nums[i];
            if(num == 0) res++;
            for (int j = i + 1; j < nums.length; j++) {
                num -= nums[j];
                if(num == 0) res++;
            }
        }
        return res;
    }*/
    //2.前缀和
    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0,count = 0;
        map.put(0,1);//初始化为0的前缀和为1
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if(map.containsKey(count - k)){
                res += map.get(count - k);
            }
            map.put(count,map.getOrDefault(count,0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(subarraySum(nums,3));
    }
}
