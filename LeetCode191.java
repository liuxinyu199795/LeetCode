import java.util.Arrays;

public class LeetCode191 {
    //在末尾每次减一
    public int hammingWeight(int n) {
        int res=0;
        while(n!=0){
            ++res;
            n=n&(n-1);
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
