public class Jianz017 {
    public int[] printNumbers (int n) {
        // write code here
        int num = 1;
        while(n-- != 0) num *= 10;
        int[] res = new int[num - 1];
        for (int i = 0; i < num - 1; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
