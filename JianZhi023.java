/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi023 {
    //1.递归（判断左子树是否都比根小，右子树是否都比根大）
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length - 1);
    }
    public boolean recur(int[] nums,int i,int j){
        if(i >= j) return true;
        int m = i;
        while(nums[m] < nums[j]) m++;
        int left = m;
        while(nums[m] > nums[j]) m++;
        return m == j && recur(nums,i,left - 1) && recur(nums,left,m - 1);
    }
}
