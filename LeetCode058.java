import com.sun.deploy.util.StringUtils;

public class LeetCode058 {
    public int lengthOfLastWord(String s) {
        String[] split = s.split(" ");
        int length = 0;
        for (String str : split) {
            if(!str.equals(" ")){
                length = str.length();
            }
        }
        return length;
    }

    public static void main(String[] args) {
        String str = "   fly me   to   the moon  ";
        String[] s = str.split(" ");
        System.out.println(s);
    }
}
