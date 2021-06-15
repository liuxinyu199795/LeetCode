/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode852 {
    //1.二分查找
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0,right = arr.length - 1,max = Integer.MIN_VALUE;
        while(left < right){
            int mid = left + right >> 1;
            if(arr[mid] < arr[right] && arr[mid] > arr[left] || arr[mid] > arr[mid - 1] && arr[mid + 1] > arr[mid]){
                left = mid + 1;
            }else if(arr[mid] > arr[right] && arr[mid] < arr[left] || arr[mid] < arr[mid - 1] && arr[mid + 1] < arr[mid]){
                right = mid;
            }else{
                return mid;
            }
        }
        return 0;
    }
}
