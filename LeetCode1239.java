import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1239 {
    //1.普通dfs
    StringBuffer sb = new StringBuffer();
    int res = 0;
    public int maxLength(List<String> arr) {
        recur(arr,0);
        return res;
    }
    public void recur(List<String> arr,int i){
        char[] chars = sb.toString().toCharArray();
        Set<Character> set = new HashSet<>();
        for (char s : chars) {
            if(set.contains(s)){
                return;
            }else{
                set.add(s);
            }
        }
        res = Math.max(res,sb.length());
        for (int j = i; j < arr.size(); j++) {
            sb.append(arr.get(j));
            recur(arr,j+1);
            sb.delete(sb.length() - arr.get(j).length(),sb.length());
        }
    }
}
