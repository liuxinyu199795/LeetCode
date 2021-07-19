import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1838 {
    //1.排序+最大前缀和+二分查找+滑动窗口
    int[] _nums,_sums;int _k;
    public int maxFrequency(int[] nums, int k) {
        int length = nums.length;
        Arrays.sort(nums);
        _nums = nums; _k = k;
        int[] sums = new int[length + 1];
        for (int i = 1; i <= length; i++) {
            sums[i] = nums[i - 1] + sums[i - 1];
        }
        _sums = sums;
        int left = 0,right = length;
        while(left < right){
            int mid = left + right + 1 >> 1;
            if(check(mid)) left = mid;
            else right = mid - 1;
        }
        return right;
    }
    public boolean check(int len){
        int length = _nums.length;
        for (int l = 0; l + len - 1 < length; l++) {
            int r = l + len - 1;
            int sum = _sums[r + 1] - _sums[l];
            int res = _nums[r] * len;
            if(res - sum <= _k) return true;
        }
        return false;
    }
}
