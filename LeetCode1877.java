import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1877 {
    //1.排序+贪心+双指针
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int res = Integer.MIN_VALUE;
        while(left < right){
           int sum = nums[left] + nums[right];
           if(res < sum) res = sum;
           left++;
           right--;
        }
        return res;
    }
}
