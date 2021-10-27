import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode301 {
    //1.DFS剪枝
    Set<String> set = new HashSet<>();
    int n,max,len;
    String s;
    public List<String> removeInvalidParentheses(String _s) {
        s = _s;
        n = s.length();
        int l = 0,r = 0;
        for (char c : s.toCharArray()) {
            if(c == '(') l++;
            else if(c == ')') r++;
        }
        max = Math.min(l,r);//算出合理最大的长度
        dfs(0,"",0);
        return new ArrayList<>(set);
    }
    void dfs(int u,String cur,int score){
        if(score < 0 || score > max) return;
        if(u == n){
            if(score == 0 && cur.length() >= len){
                if(cur.length() > len) set.clear();
                len = cur.length();
                set.add(cur);
            }
            return;
        }
        char c = s.charAt(u);
        if(c == '('){
            dfs(u + 1,cur + c,score + 1);//要这个左括号
            dfs(u + 1,cur,score);//不要这个左括号
        }else if(c == ')'){
            dfs(u + 1,cur + c,score - 1);//要这个右括号
            dfs(u + 1,cur,score);//不要这个右括号
        }else{
            dfs(u + 1,cur + c,score);
        }
    }
}
