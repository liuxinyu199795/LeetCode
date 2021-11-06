import java.util.Arrays;

public class LeetCode268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int res = -1;
        for (int num : nums) {
            if(num - res == 1){
                res = num;
            }else{
                break;
            }
        }
        return res + 1;
    }
}
