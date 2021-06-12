import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1449 {
    //1.完全背包二维
    /*public String largestNumber(int[] cost, int target) {
        String[][] dp = new String[cost.length+1][target+1];
        dp[0][0] = "";
        for(int i=1;i<=cost.length;i++){
            for(int j=0;j<=target;j++){
                if(dp[i-1][j] == null){
                    if(j >= cost[i-1] && dp[i][j-cost[i-1]] != null){
                        dp[i][j] = String.valueOf(i) + dp[i][j-cost[i-1]];
                    }
                }else{
                    dp[i][j] = dp[i-1][j];
                    if(j >= cost[i-1] && dp[i][j-cost[i-1]] != null){
                        String temp = String.valueOf(i) + dp[i][j-cost[i-1]];
                        if( dp[i][j].length() < temp.length() ||
                                (dp[i][j].length() == temp.length() && dp[i][j].compareTo(temp) < 0)){
                            dp[i][j] = temp;
                        }
                    }
                }
            }
        }
        return dp[9][target] == null ? "0" : dp[9][target];
    }*/
    //2.完全背包一维
    public String largestNumber(int[] cost, int t) {
        int[] f = new int[t + 1];
        Arrays.fill(f, Integer.MIN_VALUE);
        f[0] = 0;
        for (int i = 1; i <= 9; i++) {
            int u = cost[i - 1];
            for (int j = u; j <= t; j++) {
                f[j] = Math.max(f[j], f[j - u] + 1);
            }
        }
        if (f[t] < 0) return "0";
        String ans = "";
        for (int i = 9, j = t; i >= 1; i--) {
            int u = cost[i - 1];
            while (j >= u && f[j] == f[j - u] + 1) {
                ans += String.valueOf(i);
                j -= u;
            }
        }
        return ans;
    }
}
