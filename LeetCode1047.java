/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1047 {
    //1.栈解法
    /*public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <S.length() ; i++) {
            if((!stack.isEmpty())&&((stack.peek()==S.charAt(i)))){
                stack.pop();
            }else{
                stack.push(S.charAt(i));
            }
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }*/
    //2.数组实现
    public String removeDuplicates(String S) {
        char[] res = new char[S.length()];
        int i=-1;
        for (char c:S.toCharArray()) {
            if((i>=0)&&(c==res[i])){
                i--;
            }else{
                res[++i]=c;
            }
        }

        return new String(res, 0, i + 1);
    }
}
