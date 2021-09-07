import java.util.Stack;

public class LeetCode1221 {
    public int balancedStringSplit(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int res = 0,length = chars.length;
        for (int i = 0; i < length; i++) {
            int j = i + 1,score = chars[i] == 'L' ? 1 : -1;
            while(j < length && score != 0) score += chars[j] == 'L' ? 1 : -1;
            i = j;
            res++;
        }
        return res;
    }
}
