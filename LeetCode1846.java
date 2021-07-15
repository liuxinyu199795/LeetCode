import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1846 {
    //1.贪心（每次都考虑，超过就设置为+1）
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int length = arr.length;
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if(Math.abs(arr[i] - arr[i - 1]) > 1){
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[length - 1];
    }
}
