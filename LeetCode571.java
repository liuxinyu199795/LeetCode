public class LeetCode571 {
    //1.贪心
    public int findMinMoves(int[] ms) {
        int n = ms.length;
        int sum = 0;
        for (int i : ms) sum += i;
        if (sum % n != 0) return -1;
        int t = sum / n;
        int ls = 0, rs = sum;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            rs -= ms[i];
            int a = Math.max(t * i - ls, 0);
            int b = Math.max((n - i - 1) * t - rs, 0);
            ans = Math.max(ans, a + b);
            ls += ms[i];
        }
        return ans;
    }
}
