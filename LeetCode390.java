public class LeetCode390 {
    public int lastRemaining(int n) {
        int left = 1,sep = 1;
        boolean l2r = true;
        while(n > 1){
            if(l2r | n % 2 == 1){
                left += sep;
            }
            n /= 2;
            sep *= 2;
            l2r = !l2r;
        }
        return left;
    }
}
