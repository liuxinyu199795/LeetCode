import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi029 {
    //1.快排
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr,0,arr.length - 1);
        return Arrays.copyOfRange(arr, 0, k);
    }
    public void quickSort(int[] arr,int left,int right){
        if(left > right) return;
        int i = left, j = right, temp = arr[left];
        while(i < j){
            while(i < j && arr[j] > temp){
                j--;
            }
            while(i < j && arr[i] <= temp){
                i++;
            }
            if(i < j){
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[j];
        arr[j] = temp;
        quickSort(arr,left,j - 1);
        quickSort(arr,j + 1,right);
    }
}
