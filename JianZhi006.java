/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi006 {
    public static int minArray(int[] numbers) {
        int length = numbers.length,left = 0,right = length - 1;
        while(left < right){
            int mid = left + right >> 1;
            if(numbers[mid] < numbers[right]){
                right = mid;
            }else if(numbers[mid] > numbers[right]){
                left = mid + 1;
            }else{
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,3,0,1};
        System.out.println(minArray(nums));
    }
}
