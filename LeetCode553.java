public class LeetCode553 {
    //1.贪心
    public String optimalDivision(int[] nums) {
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            sb.append(nums[i]);
            sb.append("/");
        }
        if(nums.length == 2){
            res.append(nums[0]).append("/").append(sb.toString().substring(0,sb.length() - 1));
        }else if(nums.length == 1){
            res.append(nums[0]);
        }else{
            res.append(nums[0]).append("/").append("(").append(sb.toString().substring(0,sb.length() - 1)).append(")");
        }
        return res.toString();
    }
}
