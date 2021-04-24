/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode377 {
    /*//1.动态规划，基本背包问题+相同值不同顺序(处理)
    public int combinationSum4(int[] nums, int target) {
        int length = target;
        int[][] f = new int[length+1][target+1];
        f[0][0] = 1;
        int res = 0;
        for (int i = 1; i < length+1 ; i++) {
            for (int j = 0; j < target+1 ; j++) {
                for (int num : nums) {//最后一位可以是任何数(小于目标值)，遍历加起来即是同一种答案的不同排序
                    if(j >=num) f[i][j] += f[i-1][j-num];
                }
            }
            res += f[i][target];//不同长度的相同target，相加即是答案
        }
        return res;
    }*/
    //2.状态压缩的动态规划，压缩成一维的状态方程（target）
    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target+1];//目标数的多少种解法
        f[0] = 1;
        for (int i = 1; i < target+1 ; i++) {
            for (int num : nums) {
                if(i>=num) f[i] += f[i - num];
            }
        }
        return f[target];
    }
}
