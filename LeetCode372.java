public class LeetCode372 {
    //1.快速幂（dfs递归+位运算） b & 1 == 1  表示为单数，特殊处理， b>>=1,b向右移动除二
    int mod = 1337;
    public int superPow(int a, int[] b) {
        return dfs(a,b,b.length - 1);
    }
    int dfs(int a,int[] b, int c){
        if(c == -1) return 1;
        return pow(dfs(a,b,c -1),10) * pow(a,b[c]) % mod;
    }
    int pow(int a,int b){
        int ans = 1;
        a %= mod;
        while(b != 0){
            if((b & 1) != 0) ans = ans * a % mod;//单数先处理下
            a = a * a % mod;
            b >>= 1;
        }
        return ans;
    }
}
