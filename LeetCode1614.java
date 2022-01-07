public class LeetCode1614 {
    public int maxDepth(String s) {
        int num = 0,res = 0;
        for (char c : s.toCharArray()) {
            if(c == '('){
                num++;
            }else if(c == ')'){
                num--;
            }
            res = Math.max(num,res);
        }
        return num == 0 ? res : 0;
    }
}
