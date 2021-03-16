/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode59 {
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int i = 0;
        int j = 1;
        while (i < (n+1)/2) {
            for (int k = i; k < n - i; k++) {
                result[i][k] = j++;
            }
            for (int k = i+1; k < n - i; k++) {
                result[k][n - i - 1] = j++;
            }
            for (int k = n - 1 - i-1; k >= i && i < n - 1 - i; k--) {
                result[n - 1 - i][k] = j++;
            }
            for (int k = n - 1 - i-1; k >= i+1 && i < n - 1 - i; k--) {
                result[k][i] = j++;
            }
            i++;
        }
        return result;
    }
}
