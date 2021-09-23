import java.util.HashSet;
import java.util.Set;

public class LeetCode326 {
    static Set<Integer> set = new HashSet<>();
    static {
        int cur = 1;
        set.add(cur);
        while(cur <= Integer.MAX_VALUE / 3){
            cur *= 3;
            set.add(cur);
        }
    }
    public boolean isPowerOfThree(int n){
        return n > 0 && set.contains(n);
    }}
