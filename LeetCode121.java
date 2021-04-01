public class LeetCode121 {
    //1.遍历数组，求最小值，以及之后的数与最小值差值的最大值
    /*public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int min=prices[0],k=0;
        int p=0;
        for (int i = 1; i <prices.length ; i++) {
            int pp=prices[i]-min;
            if(pp>p){
                p=pp;
            }
            if(prices[i]<min){
                min=prices[i];
                k=i;
            }
        }
        return p;
    }*/
    //2.动态规划
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0) return 0;
        int[][] dp = new int[prices.length][3];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        dp[0][2]=0;
        int res=0;
        for (int i = 1; i <prices.length ; i++) {
            dp[i][0]=dp[i-1][0];
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            dp[i][2]=dp[i-1][1]+prices[i];
            res=Math.max(res,Math.max(dp[i][0],Math.max(dp[i][1],dp[i][2])));
        }
        return res;
    }
    public static void main(String[] args) {
    }
}
