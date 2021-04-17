import java.util.TreeSet;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode220 {
    //1.双指针+滑动窗口
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int length = nums.length;
        if(length<=1) return false;
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i <length ; i++) {
            Long l = nums[i] * 1L;
            Long u = ts.floor(l);//小于并最接近l的数
            Long v = ts.ceiling(l);//大于并最接近l的数
            if(u != null && Math.abs(u-l)<=t) return true;
            if(v != null && Math.abs(v-l)<=t) return true;
            ts.add(l);
            if(i>=k) ts.remove(nums[i-k] * 1L);//移除最后一个
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(containsNearbyAlmostDuplicate(nums,3,0));
    }
}
