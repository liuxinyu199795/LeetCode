import java.util.HashMap;
import java.util.Map;

public class LeetCode1218 {
    public static int longestSubsequence(int[] arr, int difference) {
        int length = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int[][] dp = new int[length][2];
        dp[0][1] = 1;
        map.put(arr[0],0);
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
            dp[i][1] = 1;
            int tmp = arr[i] - difference;
            if(map.containsKey(tmp)) dp[i][1] = Math.max(dp[map.get(tmp)][1] + 1 ,dp[i][1]);
            map.put(arr[i],i);
        }
        return Math.max(dp[length - 1][0],dp[length - 1][1]);
    }
}
