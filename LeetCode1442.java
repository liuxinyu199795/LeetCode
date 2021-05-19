import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.Reader;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1442 {
    //1.相同两个数的异或为0，所以求区间的异或值为0
    public static int countTriplets(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                temp ^= arr[j];
                if(temp == 0){
                    res += (j - i);
                }
            }
        }
        return res;
    }
}
