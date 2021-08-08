/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1137 {
    //1.三变量储存法
    public int tribonacci(int n) {
        int n0 = 0,n1 = 1,n2 = 1;
        if(n == 0 || n == 1) return n;
        else if(n == 2) return 1;
        int i = 2;
        while(i < n){
            int tmp = n0 + n1 + n2;
            n0 = n1;
            n1 = n2;
            n2 = tmp;
            i++;
        }
        return n2;
    }
}
