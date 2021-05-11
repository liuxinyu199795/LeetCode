/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1734 {
    //1.异或
    public int[] decode(int[] encoded) {
        int n = encoded.length;
        int ABCDE = 0;
        for(int i=1; i<=n+1; i++){
            ABCDE ^= i;
        }
        int BCDE = 0;
        for(int i=1; i<n; i+=2){
            BCDE ^= encoded[i];
        }
        int[] perm = new int[n+1];
        perm[0] = ABCDE ^ BCDE;
        for(int i=1; i<n+1; i++){
            perm[i] = perm[i-1] ^ encoded[i-1];
        }
        return perm;
    }
}
