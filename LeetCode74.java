/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode74 {
    //1.全局二分查找
    /*public  boolean searchMatrix(int[][] matrix, int target) {
        int num = matrix.length * matrix[0].length;
        return dfs(matrix,0,num-1,target);
    }
    public  boolean dfs(int[][] matrix,int left,int right,int target){
        if(target>matrix[matrix.length-1][matrix[0].length-1]
                ||target<matrix[0][0] || left>right){
            return false;
        }
        int mid = (left+right)/2;
        int num = matrix[0].length;
        int p =matrix[mid/num][mid%num];
        if(target<p){
            return dfs(matrix,left,mid-1,target);
        }else if(target>p){
            return dfs(matrix,mid+1,right,target);
        }else{
            return true;
        }
    }*/
    //从最右上角判断（大于就加一行（往下走），小于就减一列（往左走）
    public  boolean searchMatrix(int[][] matrix, int target) {
        int j = matrix[0].length-1;
        int i = 0;
        if(target>matrix[matrix.length-1][matrix[0].length-1]) return false;
        if(target<matrix[0][0]) return false;
        while(j>=0&&i<=matrix.length){
            if(target<matrix[i][j]){
                j--;
            }else if(target>matrix[i][j]){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
