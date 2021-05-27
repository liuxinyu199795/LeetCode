import java.util.Stack;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1190 {
    //1.栈解
    public String reverseParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (char chars : s.toCharArray()) {
            if(chars != ')'){
                stack.push(chars);
            }else{
                StringBuffer sb = new StringBuffer();
                while(stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();//去除（
                for (char c: sb.toString().toCharArray()) {
                    stack.push(c);
                }
            }
        }
        StringBuffer sb2 = new StringBuffer();
        while(stack.size() != 0){
            sb2.append(stack.pop());
        }
        return sb2.reverse().toString();
    }
    /*//2.双端队列
    public String reverseParentheses(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        Deque<Character> d = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == ')') {
                StringBuilder path = new StringBuilder();
                while (!d.isEmpty()) {
                    if (d.peekLast() != '(') {
                        path.append(d.pollLast());
                    } else {
                        d.pollLast();
                        for (int j = 0; j < path.length(); j++) {
                            d.addLast(path.charAt(j));
                        }
                        break;
                    }
                }
            } else {
                d.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!d.isEmpty()) sb.append(d.pollFirst());
        return sb.toString();
    }*/
    //3.数组模拟双端队列
    /*char[] deque = new char[2009];
    int head = 0, tail = -1;
    char[] path = new char[2009];
    public String reverseParentheses(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];
            if (c == ')') {
                int idx = 0;
                while (tail >= head) {
                    if (deque[tail] == '(') {
                        tail--;
                        for (int j = 0; j < idx; j++) {
                            deque[++tail] = path[j];
                        }
                        break;
                    } else {
                        path[idx++] = deque[tail--];
                    }
                }
            } else {
                deque[++tail] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (tail >= head) sb.append(deque[head++]);
        return sb.toString();
    }*/
}
