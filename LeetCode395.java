import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode395 {
    //1.递归（k个最大子串）
    public int longestSubstring(String s, int k) {
        if(s.length()<k) return 0;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for (char c:map.keySet()) {
            int res = 0;
            if(map.get(c)<k){
                for (String substr:s.split(String.valueOf(c))) {
                    res = Math.max(res,longestSubstring(substr,k));
                }
                return res;
            }
        }
        return s.length();
    }
    //2.分治（除外两边，对中间遍历，不符合则对左右递归取最大值
    public int longestSubstring1(String s, int k) {
        if(s.length()<k) return 0;
        return longestSubstring2(0,s.length()-1,s,k);
    }
    public int longestSubstring2(int left,int right,String s,int k){
        Map<Character,Integer> map = new HashMap<>();
        for (int i = left; i <=right; i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        if(right-left+1<k) return 0;
        while(right-left+1>=k && map.get(s.charAt(left))<k) left++;
        while(right-left+1>=k && map.get(s.charAt(right))<k) right--;
        if(right-left+1<k) return 0;
        for (int i = left; i <=right ; i++) {
            if(map.get(s.charAt(i))<k){
                return Math.max(longestSubstring2(left,i-1,s,k),longestSubstring2(i+1,right,s,k));
            }
        }
        return right-left+1;
    }
}
