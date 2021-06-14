/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode374 {
    //1.二分法求区间值
    public int guessNumber(int n) {
        long left = 0,right = n;
        while(left<right){
            long temp = left + right >> 1;
            int mid = (int)temp;
            if(guess(mid) == 0){
                return mid;
            }else if(guess(mid) == 1){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return (int)left;
    }
    int guess(int num){
        return 1;
    }
}
