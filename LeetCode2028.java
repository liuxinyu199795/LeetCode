import java.util.Arrays;

public class LeetCode2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length,sum = mean * (m + n);
        for (int num : rolls) sum -= num;
        if(sum < n || sum > 6 * n) return new int[0];
        int[] nums = new int[n];
        Arrays.fill(nums,sum / n);
        if(sum / n * n < sum){//有余数
            int d = sum - (sum / n * n),idx = 0;
            while (d-- > 0) nums[idx++]++;
        }
        return nums;
    }
}
