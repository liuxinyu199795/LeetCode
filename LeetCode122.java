import java.util.Arrays;

public class LeetCode122 {
    //1.贪心法，局部最优->全局最优
    public int maxProfit(int[] prices) {
        int sum=0;
        for (int i = 0; i <prices.length-1 ; i++) {
            if(prices[i]<prices[i+1]){
                sum+=prices[i+1]-prices[i];
            }
        }
        return sum;
    }
    //2.动态规划
    public static void main(String[] args) {
    }
}
