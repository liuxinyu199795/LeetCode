import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1833 {
    //1.贪心，调用内部排序（可以手写快排）
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int sum = 0, num = 0;
        for (int cost : costs) {
            sum += cost;
            if(sum > coins){
                break;
            }
            num++;
        }
        return num;
    }
}
