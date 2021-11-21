import java.util.HashMap;
import java.util.Map;

public class LeetCode397 {
    Map<Long,Integer> map = new HashMap<>();
    public int integerReplacement(int n) {
        return dfs(n * 1L);
    }
    public int dfs(Long n){
        if(n == 1) return 0;
        if(map.containsKey(n)) return map.get(n);
        int res = n % 2 == 0 ? dfs(n / 2) : Math.min(dfs(n + 1),dfs(n - 1));
        map.put(n,++res);
        return res;
    }

    public static void main(String[] args) {
    }
}
