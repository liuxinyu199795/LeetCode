import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi027 {
    //1.回溯，两两交换(Set去重）
    Set<String> set = new HashSet<>();
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        dfs(chars,0);
        return set.toArray(new String[set.size()]);
    }
    public void dfs(char[] chars,int i){
        if(i == chars.length - 1){
            set.add(String.valueOf(chars));
            return;
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars,i,j);
            dfs(chars,i + 1);
            swap(chars,j,i);
        }
    }
    public void swap(char[] chars,int i,int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
