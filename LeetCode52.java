import java.util.*;

public class LeetCode52 {
    //1.dfs深度优先
    /*int res = 0;
    public int totalNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> z_diagonal = new HashSet<>();
        Set<Integer> f_diagonal = new HashSet<>();
        backtrack(0, n,col, z_diagonal, f_diagonal);
        return res;
    }
    private boolean backtrack(int i, int n,Set<Integer> col, Set<Integer> z_diagonal, Set<Integer> f_diagonal) {
        if (i == n) {
            return true;
        }
        for (int j = 0; j < n; j++) {
            if (!col.contains(j) && !z_diagonal.contains(i + j) && !f_diagonal.contains(i - j)) {
                col.add(j);
                z_diagonal.add(i + j);
                f_diagonal.add(i - j);
                if (backtrack(i+1,n,col,z_diagonal,f_diagonal)) res += 1;
                col.remove(j);
                z_diagonal.remove(i + j);
                f_diagonal.remove(i - j);
            }
        }
        return false;
    }*/
    int count = 0;
    public int totalNQueens(int n) {
        if(n<=0) return 0;
        DFS(n,0,0,0,0);
        return count;
    }
    public void DFS(int n,int rows,int cols,int pie,int na){
        if(rows==n){
            count++;
            return;
        }
        int bits = (~(cols|pie|na))&((1<<n)-1);//得到当前的空位
        while(bits>0){
            int p = bits&-bits;//取最后一个1，即合适的位置
            DFS(n,rows+1,cols|p,(pie|p)<<1,(na|p)>>1);
            bits = bits&(bits-1);//去掉最后一个1
        }
    }
    public static void main(String[] args) {

    }
}
