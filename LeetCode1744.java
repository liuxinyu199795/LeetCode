/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n = queries.length, m = candiesCount.length;
        boolean[] ans = new boolean[n];
        Long[] sum = new Long[m + 1];
        for (int i = 1; i <= m; i++) {
            sum[i] = sum[i-1] + candiesCount[i-1];//求前i-1类糖果和
        }
        for (int i = 0; i < n; i++) {
            int t = queries[i][0], d = queries[i][1] + 1, c = queries[i][2];//题目是从第0天开始，我们从第1天开始
            //sum[t]代表t-1类的糖果，+1是因为为了确保吃到，如果整除sum[t]/c就不能吃到，max代表每天吃1颗，t类吃完的时候
            long min = sum[t] / c + 1, max = sum[t + 1];
            ans[i] = min <= d && d <= max;
        }
        return ans;
    }
}
