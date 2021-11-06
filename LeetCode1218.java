import java.util.HashMap;
import java.util.Map;

public class LeetCode1218 {
    public static int longestSubsequence(int[] arr, int difference) {
        int length = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        int[][] dp = new int[length][2];
        dp[0][1] = 1;
        map.put(arr[0],0);
        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0],dp[i - 1][1]);
            dp[i][1] = 1;
            int tmp = arr[i] - difference;
            if(map.containsKey(tmp)) dp[i][1] = Math.max(dp[map.get(tmp)][1] + 1 ,dp[i][1]);
            map.put(arr[i],i);
        }
        return Math.max(dp[length - 1][0],dp[length - 1][1]);
    }

    public static void main(String[] args) {
        /*String s1 = new String("abc");//语句1
        String s2 = "abc";//语句2
        String s3 = new String("abc");//语句3

        System.out.println(s1 == s2);//语句4
        System.out.println(s1 == s3);//语句5
        System.out.println(s2 == s3);//语句6

        System.out.println(s1 == s1.intern());//语句7
        System.out.println(s2 == s2.intern());//语句8
        System.out.println(s1.intern() == s2.intern());//语句9

        String hello = "hello";//语句10
        String hel = "hel";//语句11
        String lo = "lo";//语句12

        System.out.println(hello == "hello");//语句13
        System.out.println(hello == "hel" + "lo");//语句14
        System.out.println(hello == "hel" + lo);//语句15
        System.out.println(hello == hel + lo);//语句16

        String s = new String("hello");
        System.out.println(s.intern()==s);*/

        String sb = new StringBuilder().append("hel").append("lo").toString();
        System.out.println(sb.intern() == sb);
        String ss = new String("hel");
        System.out.println(ss == ss.intern());

        String sb1 = new StringBuilder().append("lx").append("y").toString();
        System.out.println(sb1.intern() == sb1);
    }
}
