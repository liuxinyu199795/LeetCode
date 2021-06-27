import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode909 {
    int[] arr;
    public int snakesAndLadders(int[][] board) {
        int length = board.length;
        //1.将二维数组转成一维数组
        if(board[0][0] != -1) return -1;
        arr = new int[length * length + 1];
        boolean isRight = true;
        for (int i = length - 1,idx = 1; i >= 0; i--) {
            for (int j = (isRight ? 0 : length - 1); isRight ? j <= length - 1 : j >= 0; j += isRight ? 1 : -1) {
                arr[idx++] = board[i][j];
            }
            isRight = !isRight;
        }
        //2.BFS查找，map判断是否走过,value存走的次数
        int res = bfs();
        return res;
    }
    public int bfs(){
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer,Integer> map = new HashMap<>();
        deque.addLast(1);
        map.put(1,0);
        while(!deque.isEmpty()){
            int poll = deque.pollFirst();
            int step = map.get(poll);
            if(poll == arr.length -1) return step;
            for (int i = 1; i <= 6; i++) {
                int np = poll + i;
                if(np <=0 || np > arr.length - 1) continue;
                if(arr[np] != -1) np = arr[np];
                if(map.containsKey(np)) continue;
                map.put(np,step + 1);
                deque.addLast(np);
            }
        }
        return -1;
    }

}
