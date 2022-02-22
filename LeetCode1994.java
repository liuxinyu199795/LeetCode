public class LeetCode1994 {
    int MOD = (int)1e9+7;
    int[] p = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    int[] cnts = new int[35];
    public int numberOfGoodSubsets(int[] nums) {
        int n = nums.length;
        for (int i : nums) cnts[i]++;
        int mask = 1 << 10;
        long[] f = new long[mask];
        f[0] = 1;
        for (int i = 2; i <= 30; i++) {
            if (cnts[i] == 0) continue;
            // 对 i 进行试除
            int cur = 0, x = i;
            boolean ok = true;
            for (int j = 0; j < 10; j++) {
                int t = p[j], c = 0;
                while (x % t == 0) {
                    cur |= (1 << j);
                    x /= t; c++;
                }
                // 如果 i 能够被同一质数试除多次，说明 i 不能加到子集，跳过
                if (c > 1) {
                    ok = false;
                    break;
                }
            }
            if (!ok) continue;
            // 枚举前一状态 prev
            //（确保考虑一个新数值 i 时，依赖的子集 prev 存储的为尚未考虑 i 的方案数）
            for (int prev = mask - 1; prev >= 0; prev--) {
                // 只有当前选择数与前一状态不冲突，则能够进行转移，将方案数进行累加
                if ((prev & cur) != 0) continue;
                f[prev | cur] = (f[prev | cur] + f[prev] * cnts[i]) % MOD;
            }
        }
        long ans = 0;
        // 统计所有非空集的方案数
        for (int i = 1; i < mask; i++) ans = (ans + f[i]) % MOD;
        // 在此基础上，考虑每个 1 选择与否对答案的影响
        for (int i = 0; i < cnts[1]; i++) ans = ans * 2 % MOD;
        return (int) ans;
    }
}
