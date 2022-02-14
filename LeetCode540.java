public class LeetCode540 {
    //1.步长为2进行遍历
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        int l = 0,r = length - 1;
        while(l < r){
            int mid = l + r >> 1;
            if(mid % 2 == 0){
                if(mid + 1 < length && nums[mid] == nums[mid + 1]) l = mid + 1;
                else r = mid;
            }else{
                if(mid - 1 >= 0 && nums[mid] == nums[mid - 1]) l = mid + 1;
                else r = mid;
            }
        }
        return nums[r];
    }
}
