/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode80 {
    //1.通用法,遍历每个数，与后i个数比较
    public int removeDuplicates(int[] nums) {
       int i=0;
        for (int j:nums) {
            if(i<2||nums[i-2]!=j) nums[i++] = j;
        }
        return i;
    }
    //2.双指针，用慢指针来记录当前替换的位置
}
