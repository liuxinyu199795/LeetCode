import java.util.Stack;

public class LeetCode232 {
    //入栈
    private Stack<Integer> instack;
    //出栈
    private Stack<Integer> outstack;

    /** Initialize your data structure here. */
    public LeetCode232() {
        instack = new Stack<>();
        outstack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        instack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(outstack.empty()){
            while(!instack.empty()){
                outstack.push(instack.pop());
            }
        }
        return outstack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (outstack.isEmpty()) {
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
        }
        return outstack.peek();
    }
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return instack.isEmpty() && outstack.isEmpty();
    }
    public static void main(String[] args) {

    }
}
