

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode16 {
    /*public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length=nums.length;
        int d=nums[0]+nums[1]+nums[2];
        int sum=0,num=Math.abs(target-nums[0]-nums[1]-nums[2]);//三数之和，三数之和跟target的差值绝对值
        if(length==3){
            return sum;
        }
        for (int i = 0; i <length-2; i++) {
            for (int j = i+1; j <length-1 ; j++) {
                for (int k = j+1; k <length ; k++) {
                    sum=nums[i]+nums[j]+nums[k];
                    if (num>Math.abs(target-sum)){
                        num=Math.abs(target-sum);
                        d=sum;
                    }
                }
            }
        }
        return d;
    }*/
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length=nums.length;
        int closesum=nums[0]+nums[1]+nums[2];//最近的值
        if(length==3){
            return closesum;
        }
        for (int i = 0; i <length-2; i++) {
            int j=i+1,k=length-1;//定义左右双指针
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(Math.abs(target-sum)<Math.abs(target-closesum)){
                    closesum=sum;
                }
                if(sum<target){//小就左移
                    j++;
                }else if(sum>target){//大就右移
                    k--;
                }else return target;
            }
        }
        return closesum;
    }
    public static void main(String[] args) {
        int[] num={-3,0,1,2};
        System.out.println(threeSumClosest(num,1));
    }
}
