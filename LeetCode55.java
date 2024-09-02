import java.util.*;

public class LeetCode55 {
    //1.贪心 每次将最远的值存下来，看是否能达到数组末尾
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int right = 0;
        for (int i = 0; i < n; i++) {
            if(i <= right){
                right = Math.max(right,i + nums[i]);
                if(right >= n - 1){
                    return true;
                }
            }
        }
        return false;
    }
}
