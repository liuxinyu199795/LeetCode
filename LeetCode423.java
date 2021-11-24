import java.util.Arrays;

public class LeetCode423 {
    static String[] ss = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    static int[] priority = new int[]{0, 8, 6, 3, 2, 7, 5, 9, 4, 1};
    public String originalDigits(String s) {
        int n = s.length();
        int[] cnts = new int[26];
        for (int i = 0; i < n; i++) cnts[s.charAt(i) - 'a']++;
        StringBuilder sb = new StringBuilder();
        for (int i : priority) {
            int k = Integer.MAX_VALUE;
            for (char c : ss[i].toCharArray()) k = Math.min(k, cnts[c - 'a']);
            for (char c : ss[i].toCharArray()) cnts[c - 'a'] -= k;
            while (k-- > 0) sb.append(i);
        }
        char[] cs = sb.toString().toCharArray();
        Arrays.sort(cs);
        return String.valueOf(cs);
    }
}
