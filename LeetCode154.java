/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode154 {
    //1.二分法（有重复的，针对旋转后两边相同的，进行数据处理，把右边的去掉）
    public int findMin(int[] nums) {
        int length = nums.length;
        int i =0;
        int j = length-1;
        while(i<j && nums[0]==nums[j]) j--;
        while(i<j){
            int mid = i+j+1>>1;
            if(nums[mid] >= nums[0]){
                i = mid;
            }else{
                j = mid-1;
            }
        }
        return j+1 < length ? nums[j+1]:nums[0];
    }
}
