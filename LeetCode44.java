public class LeetCode44 {
    public boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        // 开始初始化填充,如果匹配的串s是空的的话，只有模式是*才能匹配
        for (int i = 0; i < p.length(); i++){
            if (dp[0][i] && p.charAt(i) == '*'){
                dp[0][i + 1] = true;
            }
        }

        // 开始动态规划
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (p.charAt(j) == '*'){
                    dp[i + 1][j + 1] = dp[i][j+1] || dp[i+1][j];
                }else if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    public static void main(String[] args) {
    }
}
