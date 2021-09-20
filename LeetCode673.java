public class LeetCode673 {
    //f[i]f[i] 为考虑以 nums[i]nums[i] 为结尾的最长上升子序列的长度。 最终答案为所有 f[0...(n - 1)]f[0...(n−1)] 中的最大值。
    //g[i]g[i] 为考虑以 nums[i]nums[i] 结尾的最长上升子序列的个数。
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] f = new int[n],g = new int[n];
        int max = 1;
        for (int i = 0; i < n; i++) {
            f[i] = g[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[j] < nums[i]){
                    if(f[i] < f[j] + 1){//说明i是比较新的
                        f[i] = f[j] + 1;
                        g[i] = g[j];
                    }else if(f[i] == f[j] + 1){
                        g[i] += g[j];
                    }
                }
            }
            max = Math.max(max,f[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {//可能有多个f[i]相同的情况
            if(f[i] == max) ans += g[i];
        }
        return ans;
    }
}
