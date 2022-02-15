import java.util.ArrayList;
import java.util.List;

public class LeetCode1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            int x = 0,y = i,min = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    x = j;
                }
            }
            int _y = 0,max = Integer.MIN_VALUE;
            for (int j = 0; j < matrix.length; j++) {
                if(matrix[j][x] > max){
                    max = matrix[j][x];
                    _y = j;
                }
            }
            if(y == _y) res.add(matrix[_y][x]);
        }
        return res;
    }
}
