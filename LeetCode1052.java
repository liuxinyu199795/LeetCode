/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1052 {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        for (int i = 0 ; i < customers.length ; i++){
            if(grumpy[i] == 0){total += customers[i];}
        }
        int max = 0;
        for (int i = 0; i <customers.length-X+1 ; i++) {
            int a=0;
            for (int j = i;j<i+X;j++) {
                if(grumpy[j] == 1){a += customers[j];}
            }
            if(a>max){max = a;}
        }
        return total+max;
    }

    public int maxSatisfied2(int[] customers, int[] grumpy, int X) {
        //前X位的计数
        int count = 0;
        for (int n=0;n<X;n++){
            count = count + customers[n]*grumpy[n];
        }
        int max = count;
        //寻找最大生气区间
        for (int i=1;i<=customers.length-X;i++){
            count = count - customers[i-1]*grumpy[i-1] + customers[i+X-1]*grumpy[i+X-1];//很巧妙 省时
            if (count>max){
                max = count;
            }
        }
        int res = 0;
        //优化 使用「秘密技巧」能得到的最终的顾客数 = 所有不生气时间内的顾客总数 + 在窗口 X 内使用「秘密技巧」挽留住的原本因为生气而被赶走顾客数。
        for (int i=0;i<customers.length;i++){
            if (grumpy[i]==0){
                res = res + customers[i];
            }
        }
        res = res + max;
        return res;
    }
}
