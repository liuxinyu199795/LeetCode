import java.util.HashSet;
import java.util.Set;

public class LeetCode367 {
    public boolean isPerfectSquare(int num) {
        long l = 0, r = num;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (mid * mid <= num) l = mid;
            else r = mid - 1;
        }
        return r * r == num;
    }
}
