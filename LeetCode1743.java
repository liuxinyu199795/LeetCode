import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1743 {
    //1.Hash表计数，用list来存左右的值
    public static int[] restoreArray(int[][] adjacentPairs) {
        int length = adjacentPairs.length ;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            int a = adjacentPairs[i][0],b = adjacentPairs[i][1];
            ArrayList<Integer> a1 = map.getOrDefault(a,new ArrayList<>());
            a1.add(b);
            map.put(a,a1);
            ArrayList<Integer> b1 = map.getOrDefault(b,new ArrayList<>());
            b1.add(a);
            map.put(b,b1);
        }
        int[] res = new int[length + 1];
        for (Map.Entry<Integer,ArrayList<Integer>> entry : map.entrySet()) {
            if(entry.getValue().size() == 1){
                res[0] = entry.getKey();
            }
        }
        for (int i = 1; i < res.length; i++) {
            res[i] = map.get(res[i - 1]).size() == 1 ? map.get(res[i - 1]).get(0)
                    : (map.get(res[i - 1]).get(0) == res[i - 2] ? map.get(res[i - 1]).get(1) :map.get(res[i - 1]).get(0));
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{2,1},{3,4},{3,2}};
        restoreArray(nums);
    }
}
