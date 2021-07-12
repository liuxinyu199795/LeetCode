import java.util.IllegalFormatCodePointException;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode275 {
    //1.二分法
    public int hIndex(int[] citations) {
        int left = 0,right = citations.length ;
        while(left < right){
            int mid = left + right + 1>> 1;
            if(check(citations,mid)) left = mid;
            else right = mid - 1;
        }
        return right;
    }
    private boolean check(int[] citations,int i){
        int ans = 0;
        for (int num : citations) {
            if(num >= i) {
                ans++;
            }
        }
        return ans >= i;
    }
}
