import java.util.Stack;

public class Jianz030 {
    //1.辅助栈
    Stack<Integer> minStack= new Stack<>();
    Stack<Integer> stack = new Stack<>();
    public void push(int node) {
        stack.push(node);
        if(minStack.isEmpty()){
            minStack.push(node);
        }else{
            if(minStack.peek() < node){
                minStack.push(minStack.peek());
            }else{
                minStack.push(node);
            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
