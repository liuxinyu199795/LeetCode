/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode7 {
    public int reverse(int x) {
        long ans = 0;
        while(x != 0){
            ans = ans * 10 + x % 10;
            x = x / 10;
        }
        return (int)ans == ans ? (int)ans : 0;
    }
}
