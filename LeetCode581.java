import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode581 {
    //1.双指针+线性排序（在中间重新划分区域）
    /*public int findUnsortedSubarray(int[] nums) {
        int i = 0,j = nums.length - 1;
        while(i < j && nums[i] <= nums[i + 1]){
            i++;
        }
        while(i < j && nums[j - 1] <= nums[j]){
            j--;
        }
        int l = i,r = j;
        int min = nums[i],max = nums[j];
        for (int k = l; k <= r; k++) {
            if(nums[k] < min){
                while(i >= 0 && nums[i] > nums[k]) i--;
            }
            if(nums[k] > max){
                while(j < nums.length && nums[j] < nums[k]) j++;
            }
        }
        return i == j ? 0 : j - i - 1;
    }*/
    //2.双指针+排序（两边第一个对不上的就是）
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        while (i <= j && nums[i] == arr[i]) i++;
        while (i <= j && nums[j] == arr[j]) j--;
        return j - i + 1;
    }
}
