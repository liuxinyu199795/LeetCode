public class LeetCode441 {
    //1.求根公式
    /*public int arrangeCoins(int n) {
        return (int)((Math.sqrt(1 + 8.0 * n) - 1) / 2);
    }*/

    public int arrangeCoins(int n) {
        long l = 0,r = n;
        while(l < n){
            long mid = l + r + 1>> 1;
            if(mid * (mid + 1) / 2  <= n) l = mid;
            else r = mid - 1;
        }
        return (int)r;
    }
}
