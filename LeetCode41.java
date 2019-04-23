import java.util.*;

public class LeetCode41 {
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int target = 1;
        for(int i=0; i < nums.length; i++) {
            if(nums[i] <= 0) {
                continue;
            }
            if(nums[i] > target) {
                return target;
            }
            if(nums[i] == target) {
                target += 1;
                continue;
            }
        }
        return target;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }
}
