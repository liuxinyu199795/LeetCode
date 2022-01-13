import java.util.Arrays;

public class LeetCode747 {
    public static int dominantIndex(int[] nums) {
        int length = nums.length;
        if(nums.length < 2) return 0;
        int max = nums[0],lowMax = 0,res = 0;
        for (int i = 1; i < length; i++) {
            if(nums[i] > max){
                lowMax = max;
                max = nums[i];
                res = i;
            }else{
                if(nums[i] > lowMax) lowMax = nums[i];
            }
        }
        if(max >= 2 * lowMax) return res;
        return -1;
    }

    public static void main(String[] args) {
        int[] num = new int[]{3,6,1,0};
        dominantIndex(num);
    }
}
