import java.util.HashSet;
import java.util.Set;

public class LeetCode128 {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest = 0;
        int cur = 1;
        for(int num : set){
            //找set里是否有比自己小的，没有说明是最小的，开始算长度，有则跳过
            if(!set.contains(num - 1)){
                cur = 1;
                while (set.contains(num + 1)){
                    cur++;
                    num++;
                }
                longest = Math.max(longest,cur);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }
}
