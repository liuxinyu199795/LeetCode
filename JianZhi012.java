/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi012 {
    //1.暴力法
    public static double myPow(double x, int n) {
        double res = 1l;
        long l = n;
        if(l == 0) return res;
        if(l < 0){
            l = -l;
            x = 1 / x;
        }
        while(l > 0){
            if((l & 1) == 1) res *= x;
            x *= x;
            l >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000,10));
    }
}
