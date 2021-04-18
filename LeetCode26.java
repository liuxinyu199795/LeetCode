


public class LeetCode26 {
    //1.双指针法
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if(nums[j] != nums[i]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,2};
        System.out.println(removeDuplicates(nums));
    }
}
