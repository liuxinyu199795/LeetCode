import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode456 {
    //1.暴力法，只要左边有最小的，以每个为最大的，遍历后面的数，n2时间复杂度
    /*public boolean find132pattern(int[] nums) {
        if(nums.length<=2) return false;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]>min){
                for (int j = i+1; j <nums.length ; j++) {
                    if(nums[j]>min && nums[j]<nums[i]){
                        return true;
                    }
                }
            }else{
                min = nums[i];
            }
        }
        return false;
    }*/
    //2.单调栈，求一个数小于最大被排出的情况，单调递减栈，最下面是最大的
    public boolean find132pattern(int[] nums) {
        if(nums.length<=2) return false;
        Deque<Integer> deque = new ArrayDeque<>();
        int max = Integer.MIN_VALUE;
        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]<max) return true;
            while(!deque.isEmpty() && nums[i]>deque.peekLast()){
                max = Math.max(max,deque.pollLast());
            }
            deque.addLast(nums[i]);
        }
        return false;
    }
}
