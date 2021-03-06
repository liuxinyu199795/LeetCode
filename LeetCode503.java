import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode503 {
    //1.暴力法
    /*public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        if(nums.length==0||nums==null){
            return result;
        }
        for (int i = 0; i <nums.length ; i++) {
            result[i]=findNextBig(nums,i);
        }
        return result;
    }
    public int findNextBig(int[] nums,int i){
        for (int j = i+1; j <nums.length ; j++) {
            if(nums[j]>nums[i]) return nums[j];
        }
        for (int j = 0; j <i ; j++) {
            if(nums[j]>nums[i]) return nums[j];
        }
        return -1;
    }*/
    //2.建立单调栈，把不符合的下标都放进去，如果又符合的数，则拿出部分（适用于下一个最大/小元素）
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        if(nums.length==0||nums==null){
            return result;
        }
        Arrays.fill(result,-1);
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i <2*n ; i++) {
            while(!queue.isEmpty()&&nums[i%n]>nums[queue.peekLast()]){
                int j = queue.pollLast();
                result[j]=nums[i%n];
            }
            queue.addLast(i%n);
        }
        return result;
    }
}
