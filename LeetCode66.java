import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode66 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        digits[n - 1]++;
        List<Integer> list = new ArrayList<>();
        for (int i = n - 1, t = 0; i >= 0 || t != 0; i--) {
            int x = i >= 0 ? digits[i] + t : t;
            list.add(x % 10);
            t = x / 10;
        }
        Collections.reverse(list);
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
        return ans;
    }
}
