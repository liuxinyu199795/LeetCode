public class LeetCode1995 {
    public int countQuadruplets(int[] nums) {
        int length =  nums.length, res = 0;
        int[] cnt = new int[10010];
        for (int i = length - 2; i >= 2; i--) {
            cnt[nums[i+1]]++;
            for (int j = 0; j < length; j++) {
                for (int k = j + 1; k < i; k++) {
                    res += cnt[nums[j] + nums[k] + nums[i]];
                }
            }
        }
        return res;
    }
}
