/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi011 {
    //1.位运算 n&n-1是取得最后一个1
    public int hammingWeight(int n) {
        int res = 0;
        while(n != 0){
            res ++;
            n = n & n - 1;
        }
        return res;
    }
}
