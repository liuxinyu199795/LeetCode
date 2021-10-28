import java.util.HashSet;
import java.util.Set;

public class LeetCode869 {
    //1.预处理 + 回溯
    static Set<Integer> set = new HashSet<>();
    static {
        for (int i = 1; i < Math.pow(10,9); i *= 2) set.add(i);
    }
    int m;//代表位数
    int[] cnts = new int[10];//代表0-9
    public boolean reorderedPowerOf2(int n) {
        while(n != 0){
            cnts[n % 10]++;
            n /= 10;
            m++;
        }
        return dfs(0,0);
    }
    boolean dfs(int u ,int cur){
        if(u == m) return set.contains(cur);
        for (int i = 0; i < 10; i++) {//从剩下的数字中选一位
            if(cnts[i] != 0){
                cnts[i]--;
                if((i != 0 || cur != 0) && dfs(u + 1,cur * 10 + i)) return true;//表示取这个数为前面的数字
                cnts[i]++;//回溯
            }
        }
        return false;
    }
}
