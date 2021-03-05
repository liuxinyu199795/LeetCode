import java.util.Arrays;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode354 {
    //1.暴力动规
    public int maxEnvelopes(int[][] es) {
        int n = es.length;
        if(n==0) return 0;
        Arrays.sort(es, (a, b)->a[0]-b[0]);//排序，长的差值
        int[] f = new int[n];
        int result = 1;
        for (int i = 0; i <n ; i++) {//对于每个值，向后遍历，是否有合适的
            f[i]=1;
            for (int j = i-1; j >=0 ; j--) {
                if(check(es,i,j)){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
            result = Math.max(result,f[i]);
        }
        return result;
    }
    //2.
    public boolean check(int[][] es,int i,int j){
        return es[i][0]>es[j][0] && es[i][1]>es[j][1];//比较长宽
    }
}
