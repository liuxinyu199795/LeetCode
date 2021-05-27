/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode461 {
    public int hammingDistance(int x, int y) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int a = (x >> i) & 1, b = (y >> i) & 1;//左移几位的最后一位数
            res += a ^ b;
        }
        return res;
    }
}
