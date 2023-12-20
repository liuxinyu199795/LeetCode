public class LeetCode283 {
    public static void moveZeroes(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if(nums[i] != 0) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[j] == 0)continue;
                nums[j-1] = nums[j];
                nums[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        moveZeroes(nums);
    }
}
