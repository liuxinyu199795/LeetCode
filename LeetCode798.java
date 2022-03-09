import java.util.Arrays;

public class LeetCode798 {
    static int N = 100010;
    static int[] c = new int[N];
    void add(int l, int r) {
        c[l] += 1; c[r + 1] -= 1;
    }
    public int bestRotation(int[] nums) {
        Arrays.fill(c, 0);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int a = (i - (n - 1) + n) % n, b = (i - nums[i] + n) % n;
            if (a <= b) {
                add(a, b);
            } else {
                add(0, b);
                add(a, n - 1);
            }
        }
        for (int i = 1; i <= n; i++) c[i] += c[i - 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (c[i] > c[ans]) ans = i;
        }
        return ans;
    }
}
