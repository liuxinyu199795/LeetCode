public class LeetCode440 {
    public int findKthNumber(int n, int k) {
        int ans = 1;
        while(k > 1){
            int cur = getCur(ans,n);
            if(cur < k){
                k -= cur;
                ans++;
            }else{
                k--;
                ans *= 10;
            }
        }
        return ans;
    }
    public int getCur(int x,int n){
        String s1 = String.valueOf(x),s2 = String.valueOf(n);
        int a = s1.length(),b = s2.length(),k = b - a,cur = 0,u = Integer.parseInt(s2.substring(0,a));
        for (int i = 0; i < k; i++) cur += Math.pow(10,i);
        if(u > x){
            cur += Math.pow(10,k);
        }else if(u == x){
            cur += n - x * Math.pow(10,k) + 1;
        }
        return cur;
    }
}
