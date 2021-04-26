/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1011 {
    public int shipWithinDays(int[] weights, int D) {
        //1.二分法，最小值等于数组最大值，最大值为数组的和
        int max = 0, sum = 0;
        for (int num : weights) {
            max = Math.max(max,num);
            sum += num;
        }
        int left = max, right = sum;
        while(left < right){
            int mid = (left + right)>>1;
            if(check(weights,mid,D)){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
    boolean check(int[] weights,int mid,int D){
        int length = weights.length;
        int cur = 1;
        for (int i = 1,sum = weights[0]; i <length ; sum=0, cur++) {
            while(i<length && sum+weights[i]<=mid){
                sum += weights[i];
                i++;
            }
        }
        return cur-1<=D;
    }
}
