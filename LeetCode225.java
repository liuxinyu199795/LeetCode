import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LeetCode225 {
    /** Initialize your data structure here. */
    private Queue<Integer> in;
    private Queue<Integer> out;
    public LeetCode225() {
        in=new LinkedList<>();
        out=new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        in.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(!in.isEmpty()&&in.size()>1){
            out.add(in.poll());
        }
        int top=in.poll();
        in=out;
        out= new LinkedList<>();
        return top;
    }

    /** Get the top element. */
    public int top() {
        if(!in.isEmpty()&&in.size()>1){
            out.add(in.poll());
        }
        return in.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return in.isEmpty()&&out.isEmpty();
    }
    public static void main(String[] args) {

    }
}
