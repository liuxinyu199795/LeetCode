public class LeetCode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int w = matrix[0].length - 1,h = 0;
        while(w >= 0 && h < matrix.length){
            if(matrix[h][w] > target){
                w--;
            }else if(matrix[h][w] < target){
                h++;
            }else{
                return true;
            }
        }
        return false;
    }
}
