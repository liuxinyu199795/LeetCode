/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1482 {
    //1.二分查找（0，数组最大值），找满足条件的最小值
    int n, m, k;
    public int minDays(int[] nums, int _m, int _k) {
        n = nums.length;
        m = _m; k = _k;

        if (n < m * k) return -1;

        int l = 0, r = (int)1e9;
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return check(nums, r) ? r : -1;
    }
    boolean check(int[] nums, int mid) {
        int cnt = 0;
        for (int i = 0; i < n && cnt < m; ) {
            int cur = nums[i] <= mid ? 1 : 0, j = i;
            if (cur > 0) {
                while (cur < k && j + 1 < n && nums[j + 1] <= mid) {
                    j++;
                    cur++;
                }
                if (cur == k) cnt++;
                i = j + 1;
            } else {
                i++;
            }
        }
        return cnt >= m;
    }
}
