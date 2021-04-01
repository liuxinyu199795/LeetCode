
public class LeetCode48 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n<=1) return;
        //先斜着翻转
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //再竖着翻转
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][n-j-1];
                matrix[i][n-j-1]=temp;
            }
        }
    }
    public static void main(String[] args) {
        int[][] nums =new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(nums);
        for (int i = 0; i < nums.length ; i++) {
            for (int j = 0; j <nums.length ; j++) {
                System.out.println(nums[i][j]);
            }
        }
    }
}
