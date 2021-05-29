import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1074 {
    /*public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length, n = m == 0 ? 0 : matrix[0].length;
        //初始化结果数组
        int[][] num = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                num[i][j] = num[i][j - 1] + num[i - 1][j] - num[i-1][j-1] + matrix[i-1][j-1];//左列+右列-公共区+ij块
            }
        }
        int res = 0;
        //求（i,j）到（k,l）的矩形和
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= i; k++) {
                    for (int l = 1; l <= j; l++) {
                        if(num[i][j] - num[k-1][j] - num[i][l-1] + num[k-1][l-1] == target) res++;
                    }
                }
            }
        }
        return res;
    }*/
    //确定三条边，用map记录值，找到互补的值，就++;
    public int numSubmatrixSumTarget(int[][] mat, int t) {
        int n = mat.length, m = mat[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + mat[i - 1][j - 1];
            }
        }
        int ans = 0;
        for (int top = 1; top <= n; top++) {//上边
            for (int bot = top; bot <= n; bot++) {//下边
                int cur = 0;
                Map<Integer, Integer> map = new HashMap<>();
                for (int r = 1; r <= m; r++) {//右边
                    cur = sum[bot][r] - sum[top - 1][r];//求三边的
                    if (cur == t) ans++;
                    if (map.containsKey(cur - t)) ans += map.get(cur - t);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return ans;
    }
}
