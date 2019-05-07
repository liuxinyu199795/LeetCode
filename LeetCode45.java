public class LeetCode45 {
    public static int jump(int[] nums) {
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
    }
    public static void main(String[] args) {
        int[] num=new int[]{2,3,1,1,4};
        System.out.println(jump(num));
    }
}
