
public class LeetCode859 {
    //字母相等与否可以用int[]数组进行存储
    public boolean buddyStrings(String s, String goal) {
        int n = s.length(), m = goal.length();
        if (n != m) return false;
        int[] num1 = new int[26], num2 = new int[26];
        int num = 0;
        for (int i = 0; i < n; i++) {
            int j = s.charAt(i) - 'a', k = goal.charAt(i) - 'a';
            if(j != k) num++;
            num1[j]++;
            num2[k]++;
        }
        boolean ok = false;
        for (int i = 0; i < 26; i++) {
            if(num1[i] != num2[i]) return false;
            if(num1[i] > 1) ok = true;
        }
        return num == 2 || (num == 0 && ok);
    }
}
