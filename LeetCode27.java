


public class LeetCode27 {
    public static int removeElement(int[] nums, int val) {
        int i=0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]!=val){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
    public static void main(String[] args) {
      int[] nums=new int[]{1,2,3};
      System.out.println(removeElement(nums,2));
    }
}
