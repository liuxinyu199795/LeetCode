import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode981 {
    //1.定义treemap,自己写排序器
    /**
     * Initialize your data structure here.
     */
    Map<String, Map<Integer,String>> map;
    public LeetCode981() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Map<Integer,String> valueMap = map.getOrDefault(key, new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        }));
        valueMap.put(timestamp,value);
        map.put(key,valueMap);
    }

    public String get(String key, int timestamp) {
        Map<Integer, String> integerStringMap = map.get(key);
        if(integerStringMap == null) return "";
        for (Map.Entry<Integer,String> entry : integerStringMap.entrySet()) {
            if(entry.getKey() <= timestamp) return entry.getValue();

        }
        return "";
    }
}
