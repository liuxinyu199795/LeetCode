public class LeetCode639 {
    int mod = (int)1e9+7;
    public int numDecodings(String s) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        long[] f = new long[n];
        f[0] = cs[0] == '*' ? 9 : (cs[0] != '0' ? 1 : 0);
        for (int i = 1; i < n; i++) {
            char c = cs[i], prev = cs[i - 1];
            if (c == '*') {
                // cs[i] 单独作为一个 item
                f[i] += f[i - 1] * 9;
                // cs[i] 与前一个字符共同作为一个 item
                if (prev == '*') {
                    // 11 - 19 & 21 - 26
                    f[i] += (i - 2 >= 0 ? f[i - 2] : 1) * 15;
                } else {
                    int u = (int)(prev - '0');
                    if (u == 1) {
                        f[i] += (i - 2 >= 0 ? f[i - 2] : 1) * 9;
                    } else if (u == 2) {
                        f[i] += (i - 2 >= 0 ? f[i - 2] : 1) * 6;
                    }
                }
            } else {
                int t = (int)(c - '0');
                if (prev == '*') {
                    if (t == 0) {
                        f[i] += (i - 2 >= 0 ? f[i - 2] : 1) * 2;
                    } else {
                        // cs[i] 单独作为一个 item
                        f[i] += f[i - 1];
                        // cs[i] 与前一个字符共同作为一个 item
                        if (t <= 6) {
                            f[i] += (i - 2 >= 0 ? f[i - 2] : 1) * 2;
                        } else {
                            f[i] += i - 2 >= 0 ? f[i - 2] : 1;
                        }
                    }
                } else {
                    int u = (int)(prev - '0');
                    if (t == 0) {
                        if (u == 1 || u == 2) {
                            f[i] += i - 2 >= 0 ? f[i - 2] : 1;
                        }
                    } else {
                        // cs[i] 单独作为一个 item
                        f[i] += (f[i - 1]);
                        // cs[i] 与前一个字符共同作为一个 item
                        if (u == 1) {
                            f[i] += i - 2 >= 0 ? f[i - 2] : 1;
                        } else if (u == 2 && t <= 6) {
                            f[i] += i - 2 >= 0 ? f[i - 2] : 1;
                        }
                    }
                }
            }
            f[i] %= mod;
        }
        return (int)(f[n - 1]);
    }
}
