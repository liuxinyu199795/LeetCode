import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1049 {
    //01背包问题，选+还是选-，求出最接近sum/2的最大值，然后直接用 sum- 2*最大值即可
    public int lastStoneWeightII(int[] stones) {
        int length = stones.length,sum = 0;
        for (int num : stones) {
            sum += num;
        }
        int t = sum / 2;
        int[][] dp = new int[length + 1][t + 1];
        for (int i = 1; i <= length; i++) {
            int num = stones[i - 1];
            for (int j = 0; j <= t; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= num) dp[i][j] = Math.max(dp[i][j],dp[i - 1][j - num] + num);
            }
        }
        return sum - 2* dp[length][t]; //粉碎了最接近sum/2的两个，剩下的就是最小值
    }
}
