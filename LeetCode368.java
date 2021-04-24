import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode368 {
    //动态规划，遍历
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int[] f = new int[length];//记录当前最大值
        int[] g = new int[length];//记录取最大值时，上一个坐标
        int max = -1, idx = -1;//最大值和其坐标
        //遍历记录每个地方的最大值和上一个坐标
        for (int i = 0; i <length ; i++) {
            int len = 1 , pre = i;//如果没找到，长度为1，坐标为自己
            for (int j = 0; j < i ; j++) {
                if(nums[i] % nums[j] == 0 && f[j] + 1 > len){
                    len = f[j] + 1;
                    pre = j;
                }
            }
            f[i] = len;
            g[i] = pre;
            //记录最大值和下标
            if(max<len){
                max = len;
                idx = i;
            }
        }
        //根据g[]数组回溯结果
        List<Integer> list = new ArrayList<>();
        while(max != list.size()){
            list.add(nums[idx]);
            idx = g[idx];
        }
        return list;
    }
}
