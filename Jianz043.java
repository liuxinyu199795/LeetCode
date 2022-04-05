public class Jianz043 {
    public int NumberOf1Between1AndN_Solution(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        int res = 0;
        for (char c : sb.toString().toCharArray()) {
            if(c == '1') res++;
        }
        return res;
    }
}
