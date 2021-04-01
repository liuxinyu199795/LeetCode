

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode22 {
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        String str="";
        digui(str,n,0,0,list);
        return list;
    }
    public static void digui(String str,int n,int left,int right,List<String> list){
           if(str.length()==2*n){
               list.add(str);
           }
           if(left<n){
               digui(str+"(",n,left+1,right,list);
           }
           if(right<left){
               digui(str+")",n,left,right+1,list);
           }
    }
    public static void main(String[] args) {
        List<String> list1=generateParenthesis(3);
        List<String> list2=generateParenthesis(4);
        System.out.println(list1);
        System.out.println(list2);
    }
}
