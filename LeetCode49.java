import java.util.*;

public class LeetCode49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i <strs.length ; i++) {
            char[] c =strs[i].toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(map.containsKey(s)){
                List<String> p=map.get(s);
                p.add(strs[i]);
                map.put(s,p);
            }else{
                List<String> p= new ArrayList<>();
                p.add(strs[i]);
                map.put(s,p);
            }
        }
        list.addAll(map.values());
        return list;
    }
    public static void main(String[] args) {
        String[] str = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> list = groupAnagrams(str);
        System.out.println(list);
    }
}
