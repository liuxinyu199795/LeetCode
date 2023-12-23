public class LeetCode238 {
    //维护i的左右两个数组
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        int sumLeft = 1,sumRight = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            sumLeft *= nums[i];
            left[i + 1] = sumLeft;
        }
        for (int i = nums.length - 1; i > 0 ; i--) {
            sumRight *= nums[i];
            right[i - 1] = sumRight;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;
    }
}
