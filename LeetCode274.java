import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode274 {
    //1.Hash存储法
    /*public static int hIndex(int[] citations) {
        int max = 0;
        Map<Integer,Integer> number = new HashMap<>();
        for (int num : citations) {
            number.put(num,number.getOrDefault(num,0) + 1);
            if(num > max) max = num;
        }
        int temp = 0,res = 0;
        while(max != 0){
            temp += number.getOrDefault(max,0);
            if(temp >= max){
                res = max;
                break;
            }
            max--;
        }
        return res;
    }*/
    //2.二分法区间找值
    public int hIndex(int[] cs) {
        int n = cs.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(cs, mid)) l = mid;
            else r = mid - 1;
        }
        return r;
    }
    boolean check(int[] cs, int mid) {
        int ans = 0;
        for (int i : cs) if (i >= mid) ans++;
        return ans >= mid;
    }
}
