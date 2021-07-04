import com.sun.xml.internal.ws.addressing.WsaActionUtil;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode645 {
    //1.hash表（数组）来算
    public static int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] cnts = new int[n + 1];
        for (int x : nums) cnts[x]++;
        int[] ans = new int[2];
        for (int i = 1; i <= n; i++) {
            if (cnts[i] == 0) ans[1] = i;
            if (cnts[i] == 2) ans[0] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2,4};
        System.out.println(findErrorNums(nums));
    }
}
