import java.util.HashMap;
import java.util.Map;

public class LeetCode447 {
    //1.针对同一个点，用hash来存储相同的距离的个数
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length,res = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer,Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if(i == j) continue;
                int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1];
                int dist = x * x + y * y;
                map.put(dist,map.getOrDefault(dist,0) + 1);
            }
            for (int value : map.keySet()) {
                int cur = map.get(value);
                res += cur * (cur - 1);
            }
        }
        return res;
    }
}
