import java.util.Stack;

public class Jianz031 {
    //双指针+栈
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0,j = 0,m = pushA.length;
        while(i < m && j < m){
            if(!stack.isEmpty() && popA[j] == stack.peek()){
                j++;
                stack.pop();
            }else if(pushA[i] != popA[j]){
                stack.push(pushA[i]);
                i++;
            }else if(pushA[i] == popA[j]){
                i++;
                j++;
            }
        }
        while(j < m && !stack.isEmpty()){
            if(popA[j] == stack.peek()){
                stack.pop();
                j++;
            }else{
                return false;
            }
        }
        return j == m ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(IsPopOrder(new int[]{1,2,3,4,5},new int[]{4,5,3,2,1}));
    }
}
