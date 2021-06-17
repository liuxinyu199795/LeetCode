/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode65 {
    //1.模拟分类讨论
    public boolean isNumber(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if(cs[i] == 'e' || cs[i] == 'E'){
                if(idx == -1) idx = i;
                else return false;
            }
        }
        boolean ans = true;
        if(idx != -1){
            ans &= check(cs,0,idx - 1,false);
            ans &= check(cs,idx + 1,n - 1,true);
        }else{
            ans &= check(cs,0,n - 1,false);
        }
        return ans;
    }
    public boolean check(char[] cs,int start,int end,boolean mustInteger){
        if(start > end){
            return false;
        }
        if(cs[start] == '+' || cs[start] == '-') start++;
        boolean hasDot = false,hasNum = false;
        for (int i = start; i <= end; i++) {
            if(cs[i] == '.'){
                if(mustInteger || hasDot) return false;
                hasDot = true;
            }else if(cs[i] >= '0' && cs[i] <= '9'){
                hasNum = true;
            }else{
                return false;
            }
        }
        return hasNum;
    }
}
