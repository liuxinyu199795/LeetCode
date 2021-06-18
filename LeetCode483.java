/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode483 {
    public String smallestGoodBase(String n) {
        long m = Long.parseLong(n);
        int max = (int)(Math.log(m) / Math.log(2) + 1);
        for (int len = max; len >= 3; len--) {
            long k = (long)Math.pow(m, 1.0 / (len - 1));
            long res = 0;
            for (int i = 0; i < len; i++) res = res * k + 1;
            if (res == m) return String.valueOf(k);
        }
        return String.valueOf(m - 1);
    }
}
