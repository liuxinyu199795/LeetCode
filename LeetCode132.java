/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode132 {
    public int minCut(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();

        // 预处理出 st，st[i][j] 表示区间 [i,j] 是否为回文串
        boolean[][] st = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            for (int i = j; i >= 0; i--) {
                // 当 [i, j] 只有一个字符时，必然是回文串
                if (i == j) {
                    st[i][j] = true;
                } else {
                    // 当 [i, j] 长度为 2 时，满足 cs[i] == cs[j] 即回文串
                    if (j - i + 1 == 2) {
                        st[i][j] = cs[i] == cs[j];

                        // 当 [i, j] 长度大于 2 时，满足 (cs[i] == cs[j] && f[i + 1][j - 1]) 即回文串
                    } else {
                        st[i][j] = cs[i] == cs[j] && st[i + 1][j - 1];
                    }
                }
            }
        }

        // f(i) 代表考虑下标为 i 的字符为结尾的最小分割次数
        int[] f = new int[n];
        for (int j = 1; j < n; j++) {

            // 如果 [0,j] 这一段直接构成回文，则无须分割
            if (st[0][j]) {
                f[j] = 0;

                // 如果无法直接构成回文
                // 那么对于第 j 个字符，有使用分割次数，或者不使用分割次数两种选择
            } else {
                // 下边两种决策也能够合到一个循环当中去做，但是需要先将 f[i] 预设为一个足够大的数，因此干脆拆开来做

                // 独立使用一次分割次数
                f[j] = f[j - 1] + 1;

                // 第 j 个字符本身不独立使用分割次数
                // 代表要与前面的某个位置 i 形成区间 [i,j]，使得 [i, j] 形成回文，[i, j] 整体消耗一次分割次数
                for (int i = 1; i < j; i++) {
                    if (st[i][j]) {
                        f[j] = Math.min(f[j], f[i - 1] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }
}
