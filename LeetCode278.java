/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode278 {
    public int firstBadVersion(int n) {
        int left = 0,right = n;
        while(left < right){
            long temp = (long)left + right >> 1;
            int mid = (int)temp;
            if(isBadVersion(mid)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }

    boolean isBadVersion(int version){
        return true;
    }
}
