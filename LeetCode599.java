import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LeetCode599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) map.put(list1[i],i);
        List<String> res = new ArrayList<>();
        int min = 3000;
        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            if(!map.containsKey(s)) continue;
            if(i + map.get(s) < min){
                res.clear();
                min = i + map.get(s);
                res.add(s);
            }else if(i + map.get(s) == min){
                res.add(s);
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
