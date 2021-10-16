import java.util.ArrayList;
import java.util.List;

public class LeetCode282 {
    //1.回溯法
    List<String> result = new ArrayList<>();
    String s;
    int n,t;
    public List<String> addOperators(String num, int target) {
        s = num;
        n = s.length();
        t = target;
        dfs(0,0,0,"");
        return result;
    }
    void dfs(int u,long prev,long cur,String ss){
        if(u == n){
            if(cur == t) result.add(ss);
            return;
        }
        for (int i = u; i < n; i++) {
            if(i != u && s.charAt(u) == '0') break;
            long next = Long.parseLong(s.substring(u,i + 1));
            if(u == 0){
                dfs(i + 1,next,next,"" + next);
            }else{
                dfs(i + 1,next,cur + next,ss + "+" + next);
                dfs(i + 1,-next,cur - next,ss + "-" + next);
                long x = prev * next;
                dfs(i + 1,x,cur - prev + x,ss + "*" + next);
            }
        }
    }
}
