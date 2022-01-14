import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode373 {
    int[] nums1, nums2;
    int n, m;
    public List<List<Integer>> kSmallestPairs(int[] n1, int[] n2, int k) {
        nums1 = n1; nums2 = n2;
        n = nums1.length; m = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        int l = nums1[0] + nums2[0], r = nums1[n - 1] + nums2[m - 1];
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid, k)) r = mid;
            else l = mid + 1;
        }
        int x = r;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] + nums2[j] < x) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums1[i]); temp.add(nums2[j]);
                    ans.add(temp);
                } else break;
            }
        }
        for (int i = 0; i < n && ans.size() < k; i++) {
            int a = nums1[i], b = x - a;
            int c = -1, d = -1;
            l = 0; r = m - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums2[mid] >= b) r = mid;
                else l = mid + 1;
            }
            if (nums2[r] != b) continue;
            c = r;
            l = 0; r = m - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (nums2[mid] <= b) l = mid;
                else r = mid - 1;
            }
            d = r;
            for (int p = c; p <= d && ans.size() < k; p++) {
                List<Integer> temp = new ArrayList<>();
                temp.add(a); temp.add(b);
                ans.add(temp);
            }
        }
        return ans;
    }
    boolean check(int x, int k) {
        int ans = 0;
        for (int i = 0; i < n && ans < k; i++) {
            for (int j = 0; j < m && ans < k; j++) {
                if (nums1[i] + nums2[j] <= x) ans++;
                else break;
            }
        }
        return ans >= k;
    }
}
