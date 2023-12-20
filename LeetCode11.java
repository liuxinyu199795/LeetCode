public class LeetCode11 {
    public static int maxArea(int[] height) {
        int max = 0,left = 0,right = height.length - 1;
        while(left < right){
            int water = (right - left) * Math.min(height[left],height[right]);
            max = Math.max(max,water);
            //哪边矮哪边就移
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }
}
