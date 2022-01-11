public class Jianz010 {
    public int Fibonacci(int n) {
        if(n == 1 || n == 2) return 1;
        int a1 = 1;
        int a2 = 1;
        int res = 0;
        for (int i = 2; i < n; i++) {
            res = a1 + a2;
            a1 = a2;
            a2 = res;
        }
        return res;
    }
}
