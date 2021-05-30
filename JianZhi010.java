/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi010 {
    public int rectCover(int target) {
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int res = 0,a = 2,b = 1;
        for (int i = 3; i <= target; i++) {
            res = a + b;
            b = a;
            a = res;
        }
        return res;
    }
}
