import java.lang.reflect.Array;
import java.util.*;

public class LeetCode56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if(i == 0 || list.get(list.size() - 1)[1] < intervals[i][0]){
                list.add(intervals[i]);
            }else{
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1],intervals[i][1]);
            }
        }

        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        merge(nums);
    }
}
