/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode213 {
    //动态规划，分别对第一间取和不取进行讨论（第一间和最后一间相邻，不能同时取），最后取最大值
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // 第一间「必然不选」的情况
        int[][] f = new int[n][2];
        for (int i = 1; i < n - 1; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i];
        }
        int a = Math.max(f[n - 2][1], f[n - 2][0] + nums[n - 1]);

        // 第一间「允许选」的情况
        f[0][0] = 0; f[0][1] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][1]);
            f[i][1] = f[i - 1][0] + nums[i];
        }
        int b = Math.max(f[n - 2][0], f[n - 2][1]);

        return Math.max(a, b);
    }
}
