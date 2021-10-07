public class LeetCode434 {
    public int countSegments(String s) {
        int length = s.length();
        int res = 0;
        for (int i = 0; i < length;) {
            if(s.charAt(i) == ' ' && i++ >= 0) continue;
            while(i < length && s.charAt(i) != ' ') i++;
            res++;
        }
        return res;
    }
}
