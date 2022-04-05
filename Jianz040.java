import java.util.ArrayList;
import java.util.Stack;

public class Jianz040 {
    //1.双栈
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(k == 0) return res;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int index = 0;
        for (int i = 0; i < input.length; i++) {
            int tmp = input[i];
            if(stack1.isEmpty()) {
                stack1.add(tmp);
                index++;
            }else{
                while(!stack1.isEmpty()){
                    if(tmp < stack1.peek()){
                        stack2.add(stack1.pop());
                        index--;
                    }else{
                        break;
                    }
                }
                if(index < k){
                    stack1.add(tmp);
                    index++;
                }
                while(index < k && !stack2.isEmpty()){
                    stack1.add(stack2.pop());
                    index++;
                }
                stack2.clear();
            }
        }
        while(!stack1.isEmpty()) stack2.add(stack1.pop());
        while(!stack2.isEmpty()) res.add(stack2.pop());
        return res;
    }
}
