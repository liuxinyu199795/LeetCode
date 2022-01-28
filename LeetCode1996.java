import java.util.Arrays;
import java.util.Comparator;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1996 {
    public static int numberOfWeakCharacters(int[][] properties) {
        int length = properties.length;
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });
        int res = 0,max = -1;
        for (int i = 0; i < length; i++) {
            if(max > properties[i][1]){
                res++;
            }else{
                max = properties[i][1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,1},{2,1},{2,2},{1,2}};
        System.out.println(numberOfWeakCharacters(nums));
    }
}
