import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode474 {
    //1.01背包问题，二维动态规划
    public static int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        int[][] str = new int[length][2];
        int[][] sum = new int[length+1][2];
        for (int i = 0; i < length; i++) {
            Map<Character,Integer> map = new HashMap<>();
            for (char s : strs[i].toCharArray()) {
                map.put(s,map.getOrDefault(s,0) + 1);
            }
            str[i][0] = map.containsKey('0')? map.get('0') : 0;
            str[i][1] = map.containsKey('1')? map.get('1') : 0;
        }
        int[][][] dp = new int[length + 1][m + 1][n + 1];
        for (int k = 1; k <= length; k++) {
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    int a = dp[k - 1][i][j];
                    int b = (i >= str[k - 1][0] && j >= str[k - 1][1]) ?
                            dp[k - 1][i - str[k -1][0]][j - str[k -1][1]] + 1 : 0;
                    dp[k][i][j] = Math.max(a,b);
                }
            }
        }
        return dp[length][m][n];
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"10","0001","111001","1","0"};
        System.out.println(findMaxForm(strs,5,3));
    }
}
