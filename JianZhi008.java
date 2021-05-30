/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi008 {
    //1.动态规划
    /*public int numWays(int n) {
        if(n == 0) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }
        return dp[n];
    }*/
    //2.两个临时变量优化dp数组
    public int numWays(int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        int res = 0,a = 1,b = 1;
        for (int i = 2; i <= n; i++) {
            res = (a + b) % 1000000007;
            b = a;
            a = res;
        }
        return res;
    }
}
