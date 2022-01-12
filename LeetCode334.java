import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode334 {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length, ans = 1;
        int[] f = new int[n + 1];
        Arrays.fill(f, 0x3f3f3f3f);
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            int l = 1, r = i + 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (f[mid] >= t) r = mid;
                else l = mid + 1;
            }
            f[r] = t;
            ans = Math.max(ans, r);
        }
        return ans >= 3;
    }
}
