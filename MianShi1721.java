import java.sql.Array;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class MianShi1721 {
    //1.双指针解法
    /*public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i <height.length ; i++) {
            if(i==0||i==height.length-1) continue;
            int leftLength = height[i];
            int rightLength = height[i];
            //向左边
            for (int j = i-1; j>=0 ; j--) {
                if(leftLength<height[j]){
                    leftLength = height[j];
                }
            }
            //向左边
            for (int j = i+1; j<height.length ; j++) {
                if(rightLength<height[j]){
                    rightLength = height[j];
                }
            }
            int h = Math.min(rightLength,leftLength)-height[i];
            if(h>0){
                sum+=h;
            }
        }
        return sum;
    }*/
    //2.动态规划 左边最大值，右边最大值，用数组存起来
    public int trap(int[] height) {
        if(height.length<=2) return 0;
        int[] left = new int[height.length];
        left[0]=height[0];
        for (int i = 1; i < height.length ; i++) {
            left[i] =Math.max(left[i-1],height[i]);
        }
        int[] right = new int[height.length];
        right[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >=0 ; i--) {
            right[i] = Math.max(right[i+1],height[i]);
        }
        int sum =0;
        for (int i = 0; i <height.length ; i++) {
            if(i==0||i==height.length-1) continue;
            int h = Math.min(left[i],right[i])-height[i];
            if(h>0) sum+=h;
        }
        return sum;
    }
}
