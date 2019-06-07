public class LeetCode37 {
    public void solveSudoku(char[][] board) {
        if(board==null||board.length==0) return;
        solve(board);
    }
    public boolean solve(char[][] board){
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board[0].length ; j++) {
                if(board[i][j]=='.'){
                    //从1到9开始试填
                    for (char c = '1'; c <='9' ; c++) {
                        if(isValid(board,i,j,c)){
                            board[i][j]=c;
                            if(solve(board)){//进行递归，如果每一次都可以满足，则返回true
                                return true;
                            }else{
                                board[i][j]='.';//返回
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    //判断函数
    public boolean isValid(char[][] board,int row,int col,char c){
        for (int i = 0; i <9 ; i++) {
            if(board[i][col]!='.'&&board[i][col]==c) return false;//检查列
            if(board[row][i]!='.'&&board[row][i]==c) return false;//检查行
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]!='.'
                    &&board[3*(row/3)+i/3][3*(col/3)+i%3]==c) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] ints={{1,2,3},{4,5,6},{7,8,9}};
    }
}
