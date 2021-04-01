


public class LeetCode26 {
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,2};
        System.out.println(removeDuplicates(nums));
    }
}
