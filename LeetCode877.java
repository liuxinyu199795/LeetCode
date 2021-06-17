/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode877 {
    //1.贪心法
    public boolean stoneGame(int[] piles) {
        int a = 0,b = 0,c= 0,i = 0,j = piles.length-1;
        while(i<j){
            if(c % 2 == 1){
                if (piles[i] >= piles[j]) {
                    i++;
                    b += piles[i];
                } else {
                    j--;
                    b += piles[j];
                }
            }else{
                if (piles[i] >= piles[j]) {
                    i++;
                    a += piles[i];
                } else {
                    j--;
                    a += piles[j];
                }
            }
        }
        return a > b;
    }
    //2.动态规划
    /*public boolean stoneGame(int[] ps) {
        int n = ps.length;
        int[][] f = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) { // 枚举区间长度
            for (int l = 1; l + len - 1 <= n; l++) { // 枚举左端点
                int r = l + len - 1; // 计算右端点
                int a = ps[l - 1] - f[l + 1][r];
                int b = ps[r - 1] - f[l][r - 1];
                f[l][r] = Math.max(a, b);
            }
        }
        return f[1][n] > 0;
    }*/
}
