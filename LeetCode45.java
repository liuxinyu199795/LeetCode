import java.util.Arrays;

public class LeetCode45 {
    //1.动规
    /*public static int jump(int[] nums) {
        int[] dp = new int[nums.length];
        //设定一步能走的最大值
        int max =nums[0];
        //第一步能到达的地方dp赋值为1
        for (int i = 1; i <nums.length&&i<=max ; i++) {
            dp[i]=1;
        }
        //开始赋值之后的dp
        for (int i = 1; i <nums.length ; i++) {
            for (int j =max+1 ; j < nums.length&&max<=nums[i]+i; j++) {
                dp[j]=dp[i]+i;
                max=j;
            }
        }
        return dp[nums.length-1];
    }*/
    //2.动规，凡事能到的，求最小值，最终返回最后的最小值
    /*public int jump(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if(i <= j + nums[j]){
                    dp[i] = Math.min(dp[i],dp[j] + 1);
                }
            }
        }
        return dp[length - 1];
    }*/
    //3.贪心，算每次能跳到最大的，到上一次跳跃范围最右边的才重新计算下一次跳跃范围
    public int jump(int[] nums) {
        //记录当前能跳跃到的位置的边界下标
        int border = 0;
        //记录在边界范围内，能跳跃的最远位置的下标
        int max = 0;
        //记录所用步数
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            //更新最远位置下标，下一步的最远位置
            max = Math.max(max,nums[i] + i);
            if(i == border){
                border = max;//多迈出一步，将下一步最远赋给这一步
                steps++;
            }
        }
        return steps;

    }
    public static void main(String[] args) {
        int[] num=new int[]{2,3,1,1,4};
        System.out.println(jump(num));
    }
}
