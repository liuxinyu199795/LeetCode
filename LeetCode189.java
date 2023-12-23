public class LeetCode189 {
    public static void rotate(int[] nums, int k) {
        if(k % nums.length == 0) return;
        k = k % nums.length;
        int[] res = new int[nums.length];
        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            res[j++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            res[j++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1};
        rotate(nums,3);
    }
}
