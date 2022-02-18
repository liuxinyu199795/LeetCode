import java.util.HashMap;
import java.util.Map;

public class LeetCode1791 {
    public int findCenter(int[][] edges) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int[] edge : edges) {
            map.put(edge[0],map.getOrDefault(edge[0],0) + 1);
            map.put(edge[1],map.getOrDefault(edge[1],0) + 1);
        }
        int N = map.size();
        for (int key : map.keySet()) {
            if(map.get(key) == N - 1){
                return key;
            }
        }
        return -1;
    }
}
