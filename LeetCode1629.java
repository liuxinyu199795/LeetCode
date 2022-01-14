import java.util.HashMap;
import java.util.Map;

public class LeetCode1629 {
    /*public static char slowestKey(int[] releaseTimes, String keysPressed) {
        Map<Character,Integer> map = new HashMap<>();
        char[] s = keysPressed.toCharArray();
        int length  = s.length;
        for (int i = 0; i < length; i++) {
            int tmp = i == 0 ? 0 : releaseTimes[i - 1];
            if(map.getOrDefault(s[i],0) <  releaseTimes[i] - tmp){
                map.put(s[i],releaseTimes[i] - tmp);
            }
        }
        char res = s[0];
        int max = 0;
        for (int i = 0; i <26 ; i++) {
            char c = (char)('a' + i);
            if(map.containsKey(c) && map.get(c) >= max){
                max = map.get(c);
                res = c;
            }
        }
        return res;
    }*/

    public static char slowestKey(int[] releaseTimes, String keysPressed) {
        int n = releaseTimes.length,idx = 0,max = releaseTimes[0];
        for (int i = 1; i < n; i++) {
            int cur = releaseTimes[i] - releaseTimes[i - 1];
            if(cur > max){
                idx = i;max = cur;
            }else if(cur == max && keysPressed.charAt(i) > keysPressed.charAt(idx)){
                idx = i;
            }
        }
        return keysPressed.charAt(idx);
    }
}
