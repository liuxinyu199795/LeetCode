public class LeetCode231 {
    //位运算
    public static boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
    }
}
