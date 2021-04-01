import java.util.HashMap;
import java.util.Map;

public class LeetCode242 {
    public boolean isAnagram(String s, String t) {
        /*//1.排序法
        char[] char1=s.toCharArray();
        char[] char2=t.toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return String.valueOf(char1).equals(String.valueOf(char2));*/

        //2.Map
        char[] char1=s.toCharArray();
        char[] char2=t.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (char s1:char1) {
            map.put(s1,map.getOrDefault(s1,0)+1);
        }
        for (char s2:char2) {
            Integer count =map.get(s2);
            if(count==null){
                return false;
            }else if(count>0){
                map.put(s2,count-1);
            }else{
                map.remove(s2);
            }
        }
        return map.isEmpty();
    }
    public static void main(String[] args) {

    }
}
