import com.sun.deploy.util.StringUtils;

import java.util.Stack;

public class LeetCode682 {
    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String str : ops) {
            if(str.equals("C")){
                stack.pop();
            }else if(str.equals("D")){
                stack.push(stack.peek() * 2);
            }else if(str.equals("+")){
                int tmp = stack.pop();
                int sum = tmp + stack.peek();
                stack.add(tmp);
                stack.add(sum);
            }else{
                stack.add(Integer.parseInt(str));
            }
        }
        int res = 0;
        while(!stack.isEmpty()) res += stack.pop();
        return res;
    }
}
