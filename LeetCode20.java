package GaoPinSuanFa;

import java.util.Stack;

public class LeetCode20 {
    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars=s.toCharArray();
        for (char chars1:chars) {
            if(stack.size()==0){
                stack.push(chars1);
            }else if(isTrue(stack.peek(),chars1)){
                stack.pop();
            }else{
                stack.push(chars1);
            }
        }
        return stack.size()==0;
    }
    public static boolean isTrue(char c1,char c2){
        return (c1=='('&&c2==')')||(c1=='['&&c2==']')||(c1=='{'&&c2=='}');
    }
    public static void main(String[] args) {
        String str="[]{[]}()";
        System.out.println(isValid(str));
    }
}
