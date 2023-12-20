import java.util.*;

public class LeetCode49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }
        return new ArrayList<List<String>>(map.values());
    }
    public static void main(String[] args) {
        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(str);
        System.out.println(list);
    }
}
