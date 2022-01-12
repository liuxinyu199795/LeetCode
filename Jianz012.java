public class Jianz012 {
    char[][] _matrix = null;
    String _word = null;
    public boolean hasPath (char[][] matrix, String word) {
        // write code here
        _matrix = matrix;
        _word = word;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int i,int j,int k){
        if(i >= _matrix.length || i< 0 || j > _matrix[0].length || j < 0 || _matrix[i][j] != _word.charAt(k)){
            return false;
        }
        if(k == _word.length()) return true;
        char tmp = _matrix[i][j];
        _matrix[i][j] = '.';
        boolean res = dfs(i+1,j,k+1) || dfs(i-1,j,k+1) || dfs(i,j-1,k+1) || dfs(i,j+1,k+1);
        _matrix[i][j] = tmp;
        return res;
    }
}
