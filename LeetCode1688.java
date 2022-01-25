/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1688 {
    public int numberOfMatches(int n) {
        int res = 0;
        while(n != 1){
            int tmp = 0;
            if(n % 2 == 0){
                n /= 2;
                tmp = n;
            }else{
                n = (n + 1) / 2;
                tmp = n - 1;
            }
            res += tmp;
        }
        return res;
    }
}
