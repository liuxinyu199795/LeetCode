public class Jianz019 {
    public boolean match (String str, String pattern) {
        int strLen = str.length() + 1, patternLen = pattern.length() + 1;
        // 定义状态，并初始化
        boolean[][] dp = new boolean[strLen][patternLen];
        dp[0][0] = true;
        // 初始化首行
        for(int j = 2; j < patternLen; j++) {
            // 因为pattern[j-1]的 * 可以取任意值包括空值,因此dp[0][j]相当于取决于dp[0][j-2]
            if(pattern.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        // 状态转移
        for(int i = 1; i < strLen; i++) {
            for(int j = 1; j < patternLen; j++) {
                // 当比较的位pattern[j-1]=='.', 或者字符相等匹配,则状态取决于上一次状态
                if (pattern.charAt(j - 1) == '.' || str.charAt(i - 1) == pattern.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (j >= 2 && pattern.charAt(j - 1) == '*'){
                    // 对于包含 * 的匹配
                    // 当之前位为 '.', 或者字符相等,则匹配
                    if (pattern.charAt(j - 2) == '.' || pattern.charAt(j - 2) == str.charAt(i - 1)) {
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    } else {
                        // 否则只能不匹配
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[strLen - 1][patternLen - 1];
    }
}
