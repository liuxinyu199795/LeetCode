import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode554 {
    //1.转换成找空隙，用map记下每个位置的空隙数，最后用行数-最大空隙数
    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer,Integer> wallMap = new HashMap<>();
        for (int i = 0; i < wall.size() ; i++) {
            int o = 0;
            List<Integer> list = wall.get(i);
            for (int j = 0; j < list.size(); j++) {
                o += list.get(j);
                wallMap.put(o,wallMap.getOrDefault(o,0)+1);
            }
            wallMap.remove(o);//除去最后一个
        }
        int max = 0;
        for (int i : wallMap.keySet()) {
            max = Math.max(max,wallMap.get(i));
        }
        return wall.size() - max;
    }
}
