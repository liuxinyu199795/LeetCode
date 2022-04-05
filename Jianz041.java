import java.util.Stack;

public class Jianz041 {
    //1.双栈
    static Stack<Integer> stack1 = new Stack<>();
    static Stack<Integer> stack2 = new Stack<>();
    static int tmp = 0;
    public static void Insert(Integer num) {
        tmp++;
        if(stack1.isEmpty()){
            stack1.add(num);
        }else{
            while(!stack1.isEmpty() && stack1.peek() > num){
                stack2.add(stack1.pop());
            }
            stack1.add(num);
            while(!stack2.isEmpty()){
                stack1.add(stack2.pop());
            }
        }
    }

    public static Double GetMedian() {
        double res = 0;
        if(tmp % 2 == 0){
            int num = tmp / 2 - 1;
            while(num-- != 0){
                stack2.add(stack1.pop());
            }
            int a1 = stack1.peek();
            stack2.add(stack1.pop());
            int a2 = stack1.peek();
            res = (double) (a1 + a2) / 2;
        }else{
            int num = tmp / 2;
            while(num-- != 0){
                stack2.add(stack1.pop());
            }
            res = stack1.peek();
        }
        while(!stack2.isEmpty()){
            stack1.add(stack2.pop());
        }
        return res;
    }
}
