import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length, idx = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> nums[a] - nums[b]);
        boolean zero = false;
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) q.add(i);
            if (nums[i] == 0) zero = true;
            if (Math.abs(nums[i]) < Math.abs(nums[idx])) idx = i;
        }
        if (k <= q.size()) {
            while (k-- > 0) nums[q.peek()] = -nums[q.poll()];
        } else {
            while (!q.isEmpty() && k-- > 0) nums[q.peek()] = -nums[q.poll()];
            if (!zero && k % 2 != 0) nums[idx] = -nums[idx];
        }
        int ans = 0;
        for (int i : nums) ans += i;
        return ans;
    }
}
