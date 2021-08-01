import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1337 {
    //1.遍历，sort自定义排序
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[i].length ; j++) {
                if(mat[i][j] == 1) sum++;
            }
            list.add(new int[]{sum,i});
        }
        Collections.sort(list,(a,b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });
        int[] res = new int[k];
        int m = 0;
        while(m < k){
            res[m] = list.get(m)[1];
            m++;
        }
        return res;
    }
}
