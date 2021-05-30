public class LeetCode231 {
    //位运算
    public static boolean isPowerOfTwo(int n) {
        return n>0 && (n&(n-1))==0;
    }//n&n-1去到最后一个1，看是否等于0
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
    }
}
