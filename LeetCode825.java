import java.util.Arrays;

public class LeetCode825 {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length, ans = 0;
        for (int k = 0, i = 0, j = 0; k < n; k++) {
            while(i < k && !check(ages[i],ages[k])) i++;
            if(j < k) j = k;
            while(j < n && check(ages[j],ages[k])) j++;
            if(j > i) ans += j - i - 1;
        }
        return ans;
    }
    boolean check(int x, int y) {
        if (y <= 0.5 * x + 7) return false;
        if (y > x) return false;
        if (y > 100 && x < 100) return false;
        return true;
    }

}
