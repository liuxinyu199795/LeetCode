import java.util.HashSet;
import java.util.Set;

public class LeetCode318 {
    /*public int maxProduct(String[] words) {
        Set<Character> set = null;
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            set = new HashSet<>();
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }
            for (int j = i + 1; j < words.length; j++) {
                a:for (int k = 0; k < words[j].length() ; k++) {
                    if(set.contains(words[j].charAt(k))) break a;
                    if(k == words[j].length() - 1){
                        max = Math.max(words[i].length() * words[j].length(),max);
                    }
                }
            }
        }
        return max;
    }*/
    public int maxProduct(String[] words) {
        int n = words.length,idx = 0;
        int[] masks = new int[n];
        for (String str : words) {
            int t = 0;
            for (int i = 0; i < str.length(); i++) {
                int u = str.charAt(i) - 'a';
                t |= (1 << u);
            }
            masks[idx++] = t;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if((masks[i] & masks[j]) == 0) ans = Math.max(ans,words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}
