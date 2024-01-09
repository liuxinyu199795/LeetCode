import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode994 {
    public int orangesRotting(int[][] grid) {
        //1.定义2个int数组，2个一组来记录腐烂橘子的上下左右位置。腐烂橘子(0，0)
        //在矩阵中 上{-1,0}   下{1,0}  左{0,-1}   右{0,1}
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int step = 0;//感染次数
        int flash = 0;//新鲜橘子数（后面用于判定是否为-1）

        Queue<int[]> queue = new ArrayDeque<>();

        int row = grid.length;//所给矩阵行
        int col = grid[0].length;//列
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j] == 1){
                    flash++;
                }
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(flash > 0 && !queue.isEmpty()){
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int x = poll[0] + dx[j];
                    int y = poll[1] + dy[j];
                    if((x >= 0 && x < row) && (y >= 0 && y < col) && grid[x][y] == 1){
                        grid[x][y] = 2;
                        queue.offer(new int[]{x,y});
                        flash--;
                    }
                }
            }
        }
        if(flash > 0){
            return -1;
        }else{
            return step;
        }
    }
}
