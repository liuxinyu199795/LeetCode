import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1447 {
    int gcd(int a, int b) { // 欧几里得算法
        return b == 0 ? a : gcd(b, a % b);
    }
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) ans.add(i + "/" + j);
            }
        }
        return ans;
    }
}
