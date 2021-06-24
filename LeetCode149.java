import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode149 {
    //1.暴力法
    /*public static int maxPoints(int[][] points) {
        int length = points.length;
        if(length == 1) return 1;
        int res = 2;
        for (int i = 0; i < length ; i++) {
            for (int j = i + 1; j < length ; j++) {
                int temp = 2;
                for (int m = j + 1; m < length ; m++) {
                    int a = (points[j][1] - points[i][1]) * (points[m][0] - points[j][0]);
                    int b = (points[m][1] - points[j][1]) * (points[j][0] - points[i][0]);
                    if(a == b) temp++;
                }
                if(temp > res) res = temp;
            }
        }
        return res;
    }*/
    //2.哈希法+最大公约数
    public static int maxPoints(int[][] points) {
        int length = points.length;
        if(length == 1) return 1;
        int res = 0;
        for (int i = 0; i < length; i++) {
            Map<String,Integer> map = new HashMap<>();
            int max = 0;
            for (int j = i + 1; j < length; j++) {
                int a = points[j][1] - points[i][1],b = points[j][0] - points[i][0];
                int k = gcd(a,b);//求出最大公约数
                int m = a / k, n = b / k;
                String s = m + "_" + n;
                map.put(s,map.getOrDefault(s,0) + 1);
                max = Math.max(map.get(s),max);
            }
            res = Math.max(res,max + 1);
        }
        return res;
    }
    public static int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a % b);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1,1},{2,2},{3,3}};
        System.out.println(maxPoints(nums));
    }
}
