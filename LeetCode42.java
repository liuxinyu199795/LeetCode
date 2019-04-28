import java.util.Arrays;

public class LeetCode42 {
        public static int trap(int[] height) {
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

        }
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,1,2,1,5};
        System.out.println(trap(nums));
    }
}
