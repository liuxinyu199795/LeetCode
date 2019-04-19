import java.util.HashMap;

public class LeetCode36 {
    /*public static boolean isValidSudoku(char[][] board) {
        //判断每一行
        for (int i = 0; i <board.length ; i++) {
            if(!isValid(board[i])) return false;
        }
        //判断每一列
        char[] chars=new char[9];
        for (int i = 0; i <board.length ; i++) {
            for (int j = 0; j <board.length ; j++) {
                chars[j]=board[j][i];
            }
            if(!isValid(chars)) return false;
        }
        //判断每个区域
        //第一排
        char[] chars1=new char[9];
        char[] chars2=new char[9];
        char[] chars3=new char[9];
        int i=0,k=0,m=0,n=0;
        for (; i < 3; i++) {
            for (int j = 0; j <3 ; j++) {
                chars1[k++]=board[i][j];
            }
            for (int j = 3; j <6 ; j++) {
                chars2[m++]=board[i][j];
            }
            for (int j = 6; j <9 ; j++) {
                chars2[n++]=board[i][j];
            }
        }
        if(!isValid(chars1)) return false;
        if(!isValid(chars2)) return false;
        if(!isValid(chars3)) return false;
        //第二排
        int a=0,b=0,c=0;
        for (; i < 6; i++) {
            for (int j = 0; j <3 ; j++) {
                chars1[a++]=board[i][j];
            }
            for (int j = 3; j <6 ; j++) {
                chars2[b++]=board[i][j];
            }
            for (int j = 6; j <9 ; j++) {
                chars2[c++]=board[i][j];
            }
        }
        if(!isValid(chars1)) return false;
        if(!isValid(chars2)) return false;
        if(!isValid(chars3)) return false;
        //第三排
        int d=0,e=0,f=0;
        for (; i < 9; i++) {
            for (int j = 0; j <3 ; j++) {
                chars1[d++]=board[i][j];
            }
            for (int j = 3; j <6 ; j++) {
                chars2[e++]=board[i][j];
            }
            for (int j = 6; j <9 ; j++) {
                chars2[f++]=board[i][j];
            }
        }
        if(!isValid(chars1)) return false;
        if(!isValid(chars2)) return false;
        if(!isValid(chars3)) return false;
        return true;
    }*/
/*
    public boolean isValidSudoku(char[][] board) {
        //创建3个Map来记每种排列的值
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // 开始边输入变判断
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }
    public static boolean isValid(char[] chars){
        int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0;
        for (int o = 0; o <chars.length ; o++) {
            switch (chars[i]){
                case '.': break;
                case '0': a++;break;
                case '1': b++;break;
                case '2': c++;break;
                case '3': d++;break;
                case '4': e++;break;
                case '5': f++;break;
                case '6': g++;break;
                case '7': h++;break;
                case '8': i++;break;
                case '9': j++;break;
            }
            if(a==2||b==2||c==2||d==2||e==2||f==2||g==2||h==2||i==2||j==2){
                return false;
            }
        }
        return true;
    }*/
    public boolean isValidSudoku(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][10];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][10];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || block[i / 3 * 3 + j / 3][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] ints={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println();
    }
}
