public class Jianz013 {
    static int _threshold = 0,_rows = 0,_cols = 0;
    static boolean[][] visited;
    public static int movingCount(int threshold, int rows, int cols) {
        _threshold = threshold;
        _rows = rows;
        _cols = cols;
        visited = new boolean[rows][cols];
        return dfs(0,0);
    }
    public static int dfs(int r,int c){
        if(r >= _rows || c >= _cols || visited[r][c] || check(r,c) > _threshold) return 0;
        visited[r][c] = true;
        return dfs(r + 1,c) + dfs(r,c + 1)+ 1;
    }
    public static int check(int i,int j){
        int sum = 0;
        //计算坐标i所有数字的和
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        //计算坐标j所有数字的和
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(15,20,20));

    }
}
