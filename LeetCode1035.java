/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1035 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] f = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i-1][j], f[i][j-1]);//包含f[i-1][j-1]
                if(nums1[i-1] == nums2[j-1]){
                    f[i][j] = Math.max(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }
        return f[n][m];
    }
}
