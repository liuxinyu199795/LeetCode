import java.util.Stack;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi020 {

    //1.辅助栈（用一个存放最小值的栈）
    /** initialize your data structure here. */
    Stack<Integer> stack,minStack;
    public JianZhi020() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
         stack.push(x);
         if(minStack.isEmpty() || minStack.peek() >= x) minStack.push(x);
    }

    public void pop() {
        if(stack.pop().equals(minStack.peek())){
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
