/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi001 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int length = matrix[0].length, width = matrix.length, i = 0, j = length - 1;
        while(i < width && j >= 0){
            if(target == matrix[i][j]){
                return true;
            }else if(target < matrix[i][j]){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
