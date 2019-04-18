public class LeetCode35 {
    public static int searchInsert(int[] nums, int target) {
        int length=nums.length;
        int i;
        for (i = 0; i <length ; i++) {
            if(nums[i]>=target){
                return i;
            }
        }
        return length;
    }
    public static void main(String[] args) {
        int[] nums={1,3,5,6};
        System.out.println(searchInsert(nums,0));
    }
}
