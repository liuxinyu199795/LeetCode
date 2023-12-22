import java.util.HashSet;
import java.util.Set;

public class LeetCode3 {
    //滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int right = -1,res = 0;
        for (int i = 0; i < s.length(); i++) {
            if(i != 0){
                set.remove(s.charAt(i - 1));//每次把左边的都右移一格
            }
            while(right + 1 < s.length() && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                ++right;
            }
            res = Math.max(res,right - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
