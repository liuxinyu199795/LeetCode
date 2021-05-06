/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1720 {
    //异或
    //1.相同数的异或为0
    //2.异或遵守交换律
    //3.与0的异或结果为本身
    public int[] decode(int[] encoded, int first) {
        int length = encoded.length + 1;
        int[] res = new int[length];
        res[0] = first;
        for (int i = 1; i < length; i++) {
            res[i] = res[i-1] ^ encoded[i-1];
        }
        return res;
    }
}
