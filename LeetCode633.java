/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode633 {
    //1.双指针
    /*public boolean judgeSquareSum(int c) {
        int a = 0, b = (int)Math.sqrt(c);
        while(a<=b){
            int cur = a * a + b * b;
            if(cur == c){
                return true;
            }else if(cur < c){
                a++;
            }else{
                b--;
            }
        }
        return false;
    }*/
    //2.枚举，算出最大值，for循环依次枚举
    public boolean judgeSquareSum(int c) {
        int max = (int)Math.sqrt(c);
        for (int a = 0; a <= max ; a++) {
            int b = (int)Math.sqrt(c - a * a);
            if(a * a + b * b == c) return true;
        }
        return false;
    }
}
