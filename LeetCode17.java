

import java.util.*;

public class LeetCode17 {
    public static List<String> letterCombinations(String digits) {
        if(digits.equals("")){
            return new ArrayList<String>();
        }
        char[][] temp;
        temp = new char[][]{
                {},
                {},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };
        List<Integer> indexList = new ArrayList<Integer>();
        for(int i=0;i<digits.length();i++){
            int index = digits.charAt(i)-'0';
            indexList.add(index);
        }
        Set<String> resultSet = new HashSet<String>();
        String str="";
        visit(temp,indexList,0,str,resultSet);
        return new ArrayList<String>(resultSet);
    }
    public static void visit(char[][] temp,List<Integer> indexList,int cur,
                      String str,Set<String> resultSet){
        if(cur<indexList.size()-1){
            char[] tempArray = temp[indexList.get(cur)];
            for(char s:tempArray){
                visit(temp,indexList,cur+1,str+s,resultSet);
            }
        }else{
            char[] tempArray = temp[indexList.get(cur)];
            for(char s:tempArray){
                resultSet.add(str+s);
            }
        }
    }
    public static void main(String[] args) {
        String str="234";
        System.out.println(letterCombinations(str));
    }
}
