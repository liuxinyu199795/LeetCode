public class LeetCode838 {
    static int N = 100010;
    static int[][] l = new int[N][2], r = new int[N][2];
    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        for (int i = 0, j = -1; i < n; i++) {
            if (cs[i] != '.') j = i;
            l[i] = new int[]{j, j != -1 ? cs[j] : '.'};
        }
        for (int i = n - 1, j = -1; i >= 0; i--) {
            if (cs[i] != '.') j = i;
            r[i] = new int[]{j, j != -1 ? cs[j] : '.'};
        }
        for (int i = 0; i < n; ) {
            if (cs[i] != '.' && ++i >= 0) continue;
            int j = i;
            while (j < n && cs[j] == '.') j++;
            j--;
            int[] a = l[i], b = r[j];
            int loc1 = a[0], dire1 = a[1], loc2 = b[0], dire2 = b[1];
            if (loc1 == -1 && loc2 == -1) { // 两侧无力
            } else if (loc1 == -1) { // 只有右侧有力，且力的方向向左
                if (dire2 == 'L') update(cs, i, j, 'L', 'L');
            } else if (loc2 == -1) { // 只有左侧有力，且力的方向向右
                if (dire1 == 'R') update(cs, i, j, 'R', 'R');
            } else { // 两侧有力，且两力方向「不同时」反向
                if (!(dire1 == 'L' && dire2 == 'R')) update(cs, i, j, (char)dire1, (char)dire2);
            }
            i = j + 1;
        }
        return String.valueOf(cs);
    }
    void update(char[] cs, int l, int r, char c1, char c2) {
        for (int p = l, q = r; p <= q; p++, q--) {
            if (p == q && c1 != c2) continue;
            cs[p] = c1; cs[q] = c2;
        }
    }
}
