public class LeetCode375 {
    static int N = 210;
    static int[][] cache = new int[N][N];
    public int getMoneyAmount(int n) {
        return dfs(1,n);
    }
    public int dfs(int l,int r){
        if(l > r) return 0;
        if(cache[l][r] != 0) return cache[l][r];
        int ans = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            int cur = Math.max(dfs(l,i-1),dfs(i+1,r));
            ans = Math.min(ans,cur);
        }
        cache[l][r] = ans;
        return ans;
    }
}
