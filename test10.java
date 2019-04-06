package GaoPinSuanFa;

public class test10 {
    public static boolean isMatch(String s, String p) {
        int ns = s.length() + 1;
        int np = p.length() + 1;
        boolean[][] matched = new boolean[ns][np];
        //当s字符串为空的特殊处理

        //f(0, 0)表示s字符串为空，p字符串为空的情形
        matched[0][0] = true;
        //状态转移过程
        for (int i = 0; i < ns; i++) {
            for (int j = 1; j < np; j++) {
                if(i > 0 && (p.charAt(j - 1) == '.' || p.charAt(j - 1) == s.charAt(i - 1))) {
                    matched[i][j] = matched[i - 1][j - 1];
                }
                if(p.charAt(j - 1) == '*') {
                    if(i == 0 || (s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.')) {
                        matched[i][j] = matched[i][j - 2];
                    }else {
                        matched[i][j] = matched[i - 1][j] || matched[i][j - 1] || matched[i][j - 2];
                    }
                }
            }
        }
        return matched[ns - 1][np - 1];
    }
    public static void main(String[] args) {
        String str1="abc";
        String str2="abc*";
        System.out.println(isMatch(str1,str2));
    }
}
