package GaoPinSuanFa;

public class test1 {
    public static int[] twoSum(int[] nums,int target){
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,2,3,4};
        int b=4;
        int c[] = twoSum(a,b);
        for (int i = 0; i <c.length ; i++) {
            System.out.println(c[i]);
        }
    }
}
