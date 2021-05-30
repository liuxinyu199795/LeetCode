/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi007 {
    //1.动态规划（用数组来存之前的结果，避免重复计算）
    /*public int fib(int n) {
        int[] num = new int[n+1];
        num[0] = 0;
        if(n == 0) return 0;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            num[i] = (num[i-1] + num[i-2]) % 1000000007;
        }
        return num[n];
    }*/
    //2.优化（用两个变量来记录，不需要数组）
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
