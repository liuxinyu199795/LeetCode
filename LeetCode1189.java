import java.util.HashMap;
import java.util.Map;

public class LeetCode1189 {
    public int maxNumberOfBalloons(String text) {
        Map<Character,Integer> map = new HashMap<>();
        for (Character c : text.toCharArray()) {
            map.put(c,map.getOrDefault(c,0) + 1);
        }
        int max = Integer.MAX_VALUE;
        String str = "ban";
        String str2 = "ol";
        for (Character c : str.toCharArray()) {
            if(map.containsKey(c)){
                max = Math.min(max,map.get(c));
            }else{
                return 0;
            }
        }
        for (Character c : str2.toCharArray()) {
            if(map.containsKey(c)){
                max = Math.min(max,map.get(c)/2);
            }else{
                return 0;
            }
        }
        return max;
    }
}
