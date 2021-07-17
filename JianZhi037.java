/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi037 {
    //1.二分查找 然后前后比较
    public int search(int[] nums, int t) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= t) l = mid;
            else r = mid - 1;
        }
        int ans = 0;
        while (r >= 0 && nums[r] == t && r-- >= 0) ans++;
        return ans;
    }
}
