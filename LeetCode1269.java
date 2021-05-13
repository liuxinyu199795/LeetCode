/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1269 {
    //1.二位dp，第一位是剩余步数，第二位是距离原点多远
    public int numWays(int steps, int arrLen) {
        int mod = (int)1e9+7;
        int max = Math.min(steps / 2, arrLen - 1);
        int[][] res = new int[steps + 1][max + 1];
        res[steps][0] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            for (int j = 0; j <= max; j++) {
                res[i][j] = (res[i][j] + res[i+1][j]) % mod;
                if(j - 1 >= 0){
                    res[i][j] = (res[i][j] + res[i+1][j-1]) % mod;
                }
                if(j + 1 <= max){
                    res[i][j] = (res[i][j] + res[i+1][j+1]) % mod;
                }
            }
        }
        return res[0][0];
    }
}
