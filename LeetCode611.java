import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode611 {
    //1.排序+暴力
    public static int triangleNumber(int[] nums) {
        int length = nums.length,res = 0;
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if(nums[i] + nums[j] > nums[k] && nums[i] + nums[k] > nums[j]
                        && nums[k] + nums[j] > nums[i]){
                        res++;
                    }
                }
            }
        }
        return res;
    }
    //2.

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
}
