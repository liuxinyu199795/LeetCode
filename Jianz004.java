public class Jianz004 {
    public boolean Find(int target, int [][] array) {
        int j = array[0].length - 1;
        int i = 0;
        while(i < array.length && j >= 0){
            if(target > array[i][j]){
                i++;
            }else if(target < array[i][j]){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }
}
