/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1310 {
    int n;
    int[] c = new int[100009];
    int lowbit(int x) {
        return x & -x;
    }
    void add(int x, int u) {
        for (int i = x; i <= n; i += lowbit(i)) c[i] ^= u;
    }
    int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowbit(i)) ans ^= c[i];
        return ans;
    }
    public int[] xorQueries(int[] arr, int[][] qs) {
        n = arr.length;
        int m = qs.length;
        for (int i = 1; i <= n; i++) add(i, arr[i - 1]);
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = qs[i][0] + 1, r = qs[i][1] + 1;
            ans[i] = query(r) ^ query(l - 1);
        }
        return ans;
    }
}
