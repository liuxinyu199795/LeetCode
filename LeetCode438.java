import java.util.ArrayList;
import java.util.List;

public class LeetCode438 {
    //1.滑动窗口（异位词用字符数组存储比较个数）
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length(), m = p.length();
        int[] c1 = new int[26], c2 = new int[26];
        for (int i = 0; i < m; i++) c2[p.charAt(i) - 'a']++;
        for (int l = 0,r = 0; r < n; l++) {
            c1[s.charAt(r) - 'a']++;
            if(r - l + 1 > m) c1[s.charAt(l++) - 'a']--;
            if(check(c1,c2)) ans.add(l);
        }
        return ans;
    }
    boolean check(int[] c1,int[] c2){
        for (int i = 0; i < 26; i++) {
            if(c1[i] != c2[i]) return false;
        }
        return true;
    }
}
