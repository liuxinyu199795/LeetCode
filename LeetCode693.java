public class LeetCode693 {
    public static boolean hasAlternatingBits(int n) {
        StringBuffer sb = new StringBuffer();
        boolean flag = false;
        double tmp = Math.pow(2,30);
        for (int i = 30; i >= 0 ; i--) {
            if(n >= tmp){
                flag = true;
                sb.append(1);
                n -= tmp;
            }else if(n < tmp && flag){
                sb.append(0);
            }
            tmp /= 2;
        }
        boolean res = true;
        char temp = '2';
        for (char c : sb.toString().toCharArray()) {
            if(temp == c) return false;
            else temp = c;
        }
        return res;
    }

    public static void main(String[] args) {
        hasAlternatingBits(5);
    }
}
