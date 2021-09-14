import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LeetCode524 {
    public String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary,(a,b) ->{
            if(a.length() != b.length()) return b.length() - a.length();
            return a.compareTo(b);
        });
        int n = s.length();
        for (String ss : dictionary) {
            int m = ss.length();
            int i = 0,j = 0;
            while(i < n && j < m){
                if(s.charAt(i) == ss.charAt(j)) j++;
                i++;
            }
            if(j == m) return ss;
        }
        return "";
    }
}
