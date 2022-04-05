import java.util.ArrayList;
import java.util.List;

public class LeetCode728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();
        out:for (int i = left; i <= right; i++) {
            int cur = i;
            while (cur != 0) {
                int t = cur % 10;
                if (t == 0 || i % t != 0) continue out;
                cur /= 10;
            }
            ans.add(i);
        }
        return ans;
    }
}
