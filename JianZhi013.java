/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi013 {
    //1.首尾双指针法，类似于快排
    public int[] exchange(int[] nums) {
        int length = nums.length, i = 0 , j = length - 1;
        while(i<j){
            while((nums[i] & 1) == 1 && i < j){
                i++;
            }
            while((nums[j] & 1) == 0 && i < j){
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
        return nums;
    }
}
