import java.util.ArrayList;

public class Jianz029 {
    ArrayList<Integer> res = new ArrayList<>();
    int[][] _matrix;
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix.length == 0) return res;
        int m = matrix.length,n = matrix[0].length;
        _matrix = matrix;
        print(0,n - 1,0, m - 1);
        return res;
    }
    public void print(int left,int right,int top,int bottom){
        //从左到右
        for (int i = left; i <= right; i++) res.add(_matrix[top][i]);
        top++;
        if(left > right || top > bottom) return;
        //从上到下
        for (int i = top; i <= bottom; i++) res.add(_matrix[i][right]);
        right--;
        if(left > right || top > bottom) return;
        //从右到左
        for (int i = right; i >= left; i--) res.add(_matrix[bottom][i]);
        bottom--;
        if(left > right || top > bottom) return;
        //从下到上
        for (int i = bottom; i >= top; i--) res.add(_matrix[i][left]);
        left++;
        print(left,right,top,bottom);
    }
}
