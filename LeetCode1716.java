public class LeetCode1716 {
    public static int totalMoney(int n) {
        int sum = 0,num = n / 7,seq = n % 7,add = 28;
        int a = num;
        while(a-- != 0){
            sum += add;
            add += 7;
        }
        double b = (num + 1 + num + seq) * 1.0 / 2 * seq;
        sum += b;
        return sum;
    }

    public static void main(String[] args) {
        totalMoney(10);
    }
}
