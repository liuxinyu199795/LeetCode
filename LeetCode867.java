/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode867 {
    public int[][] transpose(int[][] matrix) {
        if(matrix == null) return matrix;
        int len1 = matrix.length;
        int len2 = matrix[0].length;
        int[][] result = new int[len2][len1];
        for (int i = 0; i <len1 ; i++) {
            for (int j = 0; j <len2 ; j++) {
                result[j][i] = matrix[i][j];
             }
        }
        return result;
    }
}
