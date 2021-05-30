/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi009 {
    public int jumpFloorII(int target) {
        if(target == 0 || target == 1) return 1;
        int res = 0,a = 1;
        for (int i = 2; i <= target; i++) {
            res = 2 * a;
            a = res;
        }
        return res;
    }
}
