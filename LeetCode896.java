/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode896 {
    //1.暴力求解（一次遍历）
    public boolean isMonotonic(int[] A) {
        if(A.length == 1) return true;
        boolean flag = true;
        int m = 0;
        for (int i = 0; i <A.length-1 ; i++) {
            if(A[i]<A[i+1]){
                if(m==0){
                    m=1;
                }else if(m == -1){
                    return false;
                }
            }else if(A[i]>A[i+1]){
                if(m==0){
                    m=-1;
                }else if(m == 1){
                    return false;
                }
            }
        }
        return flag;
    }
    //2.递归
    public boolean isMonotonic1(int[] A) {
        if(A.length == 1) return true;
        return isFlag(A,0,0,false);
    }
    public boolean isFlag(int[] A,int i,int m,boolean flag){
        if(i == A.length-1){
            return true;
        }
        if((m==-1&&A[i]<A[i+1])||(m==1&&A[i]>A[i+1])){
            return false;
        }
        if(A[i]<A[i+1]&&flag==false){
            m=1;
            flag=true;
        }else if(A[i]>A[i+1]&&flag==false){
            m=-1;
            flag=true;
        }
        return isFlag(A,i+1,m,flag);
    }
    //3.两次遍历 要么递增要么递减（暴力优化）
    public boolean isMonotonic3(int[] A) {
        return isIncrease(A) || isDecrease(A);
    }

    boolean isIncrease(int[] A) {
        int N = A.length;
        for (int i = 1; i < N; ++i) {
            if (A[i] < A[i - 1])
                return false;
        }
        return true;
    }

    boolean isDecrease(int[] A) {
        int N = A.length;
        for (int i = 1; i < N; ++i) {
            if (A[i] > A[i - 1])
                return false;
        }
        return true;
    }
    //4.暴力一次遍历 代码简单
    public boolean isMonotonic4(int[] A) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 1; i < A.length; ++i) {
            if (A[i] < A[i - 1])
                inc = false;
            if (A[i] > A[i - 1])
                dec = false;
            if (!inc && !dec)
                return false;
        }
        return true;
    }

}
