import com.sun.deploy.util.StringUtils;

public class LeetCode917 {
    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0, j = n - 1; i < j;) {
            while(i < j && !Character.isLetter(chars[i])) i++;
            while (i < j && !Character.isLetter(chars[j])) j--;
            if(i < j){
                char c = chars[i];
                chars[i++] = chars[j];
                chars[j--] = c;
            }
        }
        return String.valueOf(chars);
    }
}
