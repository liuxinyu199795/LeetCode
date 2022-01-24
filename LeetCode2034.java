import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode2034 {
    int cur;
    Map<Integer,Integer> map;
    TreeMap<Integer,Integer> res;
    public LeetCode2034() {
        cur = 0;
        map = new HashMap<>();
        res = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        cur = Math.max(timestamp,cur);
        if(map.containsKey(timestamp)){
            int old = map.get(timestamp);
            int num = res.get(old);
            if(num == 1) res.remove(old);
            else res.put(old,num - 1);
        }
        map.put(timestamp,price);
        res.put(price,res.getOrDefault(price,0) + 1);
    }

    public int current() {
        return map.get(cur);
    }

    public int maximum() {
        return res.lastKey();
    }

    public int minimum() {
        return res.firstKey();
    }
}
