public class LeetCode1816 {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String str : s.split(" ")) {
            if(i == k) break;
            sb.append(str);
            sb.append(" ");
            i++;
        }
        return sb.toString().substring(0,sb.toString().length() - 1);
    }
}
