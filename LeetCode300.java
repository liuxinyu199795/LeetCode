
public class LeetCode300 {
    //1.动态规划
    /*public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int[] dp = new int[nums.length+1];
        for (int i = 0; i <nums.length ; i++) dp[i]=1;
        int res=1;
        for (int i = 1; i <nums.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res=Math.max(res,dp[i]);
        }
     return res;
    }*/
    //2.二分查找
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int maxL=0;
        int[] dp= new int[nums.length];
        for (int num:nums){
            //二分查找
            int left=0,right=maxL;
            while(left<right){
                int mid =(left+right)/2;
                if(dp[mid]<num){
                    left=mid+1;
                }else{
                    right=mid;
                }
            }
            dp[left]=num;
            if(left==maxL) maxL++;
        }
        return maxL;
    }
    public static void main(String[] args) {

    }
}
