/**
 * @ProjectName: LeetCode
 * @Author: XinyuLi
 * @Description:
 */
public class LeetCode832 {
    public static void main(String[] args) {

    }
    public int[][] flipAndInvertImage(int[][] A) {
        int length1 = A.length;
        int length2 = A[0].length;
        if(length1 == 0){return A;}
        for (int j=0; j<length1;j++){
            for (int i=0 ; 2*i < length2-1 ; i++){
                int a =A[j][i];
                A[j][i] = A[j][length2-1-i]==1?0:1;
                A[j][length2-1-i] = a==1?0:1;
            }
            if(length2%2==1){
                A[j][length2/2] =A[j][length2/2]==1?0:1;
            }
        }
        return A;
    }
}
