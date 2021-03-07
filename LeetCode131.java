import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode131 {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> result = new ArrayList<>();
        if(n==0) return result;
        Deque<String> stack = new ArrayDeque<>();
        char[] chars = s.toCharArray();
        dfs(chars,0,n,stack,result);
        return result;
    }
    public void dfs(char[] chars,int i,int len,Deque<String> stack,List<List<String>> result){
        if(i==len){
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int j = i; j <len ; j++) {
            if(!isHuiWenNumber(chars,i,j)){
               continue;
            }
            stack.addLast(new String(chars,i,j+1-i));
            dfs(chars,j+1,len,stack,result);
            stack.removeLast();
        }
    }
    public boolean isHuiWenNumber(char[] charArray,int left,int right){
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
