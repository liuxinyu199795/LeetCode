import java.util.Arrays;

public class LeetCode42 {
        /*public static int trap(int[] height) {
            if (height == null || height.length <= 2)
                return 0;
            int maxL = height[0];
            int[] maxRs = new int[height.length];
            int waterSum = 0;//计算总的水量
            int maxR = 0;
            for (int i = height.length - 1; i >= 0; i--) {
                if (height[i] > maxR) {
                    maxRs[i] = maxR = height[i];
                } else {
                    maxRs[i] = maxR;
                }
            }
            for (int i = 1; i < height.length - 1; i++) {
                if (height[i] > maxL) {
                    maxL = height[i];//更新左边最大值
                }
                waterSum += Math.max(Math.min(maxL, maxRs[i]) - height[i], 0);
            }
            return waterSum;

        }*/
        public static int trap(int[] height){
           int length=height.length;
           int max=height[0],index=0;
           //算出最高的
            for (int i = 0; i <length ; i++) {
                if(max<height[i]){
                    max=height[i];
                    index=i;
                }
            }
            //从左边开始接雨水
            int a=height[0],sumwater=0;
            for (int i = 0; i <index ; i++) {
                if(a<height[i]){
                    a=height[i];
                }else{
                    sumwater+=(a-height[i]);
                }
            }
            //从右边开始接雨水
            int b=height[length-1];
            for (int i = length-1; i>index ; i--) {
                if(a<height[i]){
                    a=height[i];
                }else{
                    sumwater+=(a-height[i]);
                }
            }
            return sumwater;
        }
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,1,2,1,5};
        System.out.println(trap(nums));
    }
}
