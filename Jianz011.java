public class Jianz011 {
    public int minNumberInRotateArray(int [] array) {
        if(array.length == 0) return 0;
        int low = 0,high = array.length - 1,mid = 0;
        while (low < high){
            if(array[low] < array[high]){
                return array[low];
            }
            mid = low + high >>1;
            if(array[mid] > array[low]){
                low = mid + 1;
            }else if(array[mid] < array[high]){
                high = mid;
            }else{
                low++;
            }
        }
        return array[low];
    }
}
