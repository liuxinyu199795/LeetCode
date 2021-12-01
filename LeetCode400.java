public class LeetCode400 {
    public int findNthDigit(int n) {
        int cur = 1,base = 9;
        while(n > cur * base){
            n -= cur * base;
            cur++;
            base *= 10;
            if(Integer.MAX_VALUE / base < cur){
                break;
            }
        }
        n--;
        int num = (int)Math.pow(10,cur - 1) + n / cur, idx = n % cur;
        return num / (int)Math.pow(10,cur - 1 - idx) % 10;
    }
}
