import java.util.LinkedList;
import java.util.Stack;

public class LeetCode239 {
    //使用双端队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums==null||nums.length<2) return nums;
        //双端队列
        LinkedList<Integer> list = new LinkedList<>();
        //结果数组
        int[] result = new int[nums.length-k+1];
        for (int i = 0; i < nums.length ; i++) {
            //如果新来的数大于前面的数，则弹出前面的数
            while(!list.isEmpty()&&nums[list.peekLast()]<=nums[i]){
                list.pollLast();
            }
            //添加值
            list.addLast(i);
            if(list.peek()<=i-k){
                list.poll();
            }
            //当窗口长度为k时，保存当前窗口最大值
            if(i-k+1>=0){
                result[i-k+1]=nums[list.peek()];
            }
        }
        return result;
    }
    public static void main(String[] args) {

    }
}
