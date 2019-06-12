import java.util.Arrays;

public class LeetCode122 {
    //1.贪心法，局部最优->全局最优
    /*public int maxProfit(int[] prices) {
        int sum=0;
        for (int i = 0; i <prices.length-1 ; i++) {
            if(prices[i]<prices[i+1]){
                sum+=prices[i+1]-prices[i];
            }
        }
        return sum;
    }*/
    //2.动态规划
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int length =prices.length;
        int[][] dp = new int[length][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        int res=0;
        for (int i = 1; i <length ; i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            res=Math.max(res,Math.max(dp[i][0],dp[i][1]));
        }
        return res;
    }
    public static void main(String[] args) {
    }
}
