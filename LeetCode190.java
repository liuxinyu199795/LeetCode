/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode190 {
    //1.对称法
    /*public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <32 ; i++) {
            int num = (n>>i)&1;//判断最后一位是1还是0
            res += num<<(31-i);//将结果左移31-i(对称)
        }
        return res;
    }*/
    //2.累加法
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i <32 ; i++) {
            res<<=1;//左移一位
            res+= n&1;//加入最后一位
            n>>=1;//右移一位
        }
        return res;
    }
}
