import java.util.Arrays;
import java.util.List;

public class LeetCode120 {
    //1.从下往上推，动态规划法
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.size()==0){
            return 0;
        }
        int[] dp = new int[triangle.size()+1];
        for (int i = triangle.size()-1; i>=0 ; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j <cur.size() ; j++) {
                dp[j]=Math.min(dp[j],dp[j+1])+cur.get(j);
            }
        }
        return dp[0];
    }
    public static void main(String[] args) {
    }
}
