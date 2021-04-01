import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Stack;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1006 {
    //1.垃圾法
    /*public static int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();
        char[] sign = new char[]{'*','/','+','-'};
        stack.push(N--);
        int i = 0;
        boolean flag = false;
        while(N!=0){
            if(sign[i%4]=='*'){
                stack.push((stack.pop() * N--));
            }else if(sign[i%4]=='/'){
                stack.push((stack.pop() / N--));
            }else if(sign[i%4]=='+'){
                if(flag){
                    stack.push(-1);
                    stack.push(N--);
                }else{
                    flag = true;
                    stack.push((stack.pop() + N--));
                }
            }else{
                stack.push(-1);
                stack.push(N--);
            }
            i++;
        }
        while(!stack.isEmpty()){
            if(stack.size()==1){
                return stack.pop();
            }
            int a = stack.pop();
            stack.pop();
            int b = stack.pop();
            stack.push(b-a);
        }
        return 0;
    }*/
    //2.优化1(栈队列法）,-号变成负数存入栈
    public static int clumsy(int N) {
        Stack<Integer> stack = new Stack<>();
        char[] sign = new char[]{'*','/','+','-'};
        stack.push(N--);
        int i = 0;
        while(N!=0){
            if(sign[i%4]=='*'){
                stack.push((stack.pop() * N--));
            }else if(sign[i%4]=='/'){
                stack.push((stack.pop() / N--));
            }else if(sign[i%4]=='+'){
                stack.push((stack.pop() + N--));
            }else{
                stack.push(-N--);
            }
            i++;
        }
        int result =0;
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}
