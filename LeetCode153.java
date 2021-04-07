/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode153 {
    //1.二分法
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l<r){
            int mid = l + r >> 1;
            if(nums[mid]>nums[r]){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return nums[l];
    }
}
