/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode115 {
    //1.动态规划
    public int numDistinct(String s, String t) {
        //dp[i][j]表示 s[j-1]中t[i-1]中出现的次数
        int[][] result = new int[t.length()+1][s.length()+1];
        for (int i = 0; i <s.length()+1 ; i++) {
            result[0][i] = 1;
        }
        for (int j = 1; j <t.length()+1 ; j++) {
            for (int i = 1; i <s.length()+1 ; i++) {
                if(s.charAt(i-1)==t.charAt(j-1)){
                    result[j][i] = result[j-1][i-1] + result[j][i-1];
                }else{
                    result[j][i] = result[j][i-1];
                }
            }
        }
        return result[t.length()][s.length()];
    }
}
