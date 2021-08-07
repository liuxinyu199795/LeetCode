/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode457 {
    //快慢指针，快指针走两步，慢指针走一步，相交则说明成环
    int[] nums;
    int n;
    public boolean circularArrayLoop(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        for (int i = 0; i < n; i++) {
            int slow = i,fast = next(i);
            //fast走两步，slow走一步，保证同号
            while(nums[slow] * nums[fast] > 0 && nums[next(fast)] * nums[slow] > 0){
                if(fast == slow){
                    if(slow == next(slow)) break;//避免1个成环
                    else return true;
                }
                slow = next(slow);
                fast = next(next(fast));
            }
        }
        return false;
    }
    public int next(int i){
        return ((i + nums[i]) % n + n) % n;//避免下标为负数
    }
}
