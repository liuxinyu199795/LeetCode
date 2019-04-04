package GaoPinSuanFa;

import java.util.ArrayList;
import java.util.List;

public class test5 {
    //暴搜解题
    /*public static String longestPalindrome(String s) {
        if(s==null||s.length()==0) return "";
        int maxlen=0;
        String maxstr="";
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length()-1; j >=i ; j--) {
                if(ques(s,i,j)&&j-i+1>maxlen){
                    maxlen= j-i+1;
                    maxstr=s.substring(i,j+1);
                    break;
                }
            }
        }
        return maxstr;
    }
    public static boolean ques(String s,int i,int j){
        if(j==i) return true;
        while(j>i){
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;
    }*/
    //dp动态规划解题
    /*public static String longestPalindrome(String s) {
        if(s==null||s.length()==0) return "";
        //length=2的情况
        char[] chars =s.toCharArray();
        int max=0;//最长回文串的长度
        int a=0,b=0;//最长时的两端
        int length = chars.length;
        int [][] dp = new int[length][length];
        for (int i = 0; i < length-1; i++) {
            dp[i][i]=1;
            if(chars[i]==chars[i+1]){
                dp[i][i+1]=1;
                max=2;
                a=i;
                b=i+1;
            }else{
                dp[i][i+1]=0;
            }
        }
        //length>=3,需要两个循环，最外面控制length的大小
        for (int len = 3; len <=length ; len++) {
            for (int i =0; i+len-1 <length ; i++) {
                if(chars[i]==chars[i+len-1]&&dp[i+1][i+len-2]==1){
                    dp[i][i+len-1]=1;
                    if(len>max){
                        max=len;
                        a=i;
                        b=i+len-1;
                    }

                }else{
                    dp[i][i+len-1]=0;
                }
            }
        }
        return s.substring(a,b+1);
    }*/
    public static String longestPalindrome(String s) {
        List<Character> s_new = new ArrayList<>();
        for(int i = 0;i < s.length();i++){
            s_new.add('#');
            s_new.add(s.charAt(i));
        }
         s_new.add('#');
        List<Integer> Len = new ArrayList<>();
        String sub = "";//最长回文子串
        int sub_midd = 0;//表示在i之前所得到的Len数组中的最大值所在位置
        int sub_side = 0;//表示以sub_midd为中心的最长回文子串的最右端在S_new中的位置
        Len.add(1);
        for(int i = 1;i < s_new.size();i++){
            if(i < sub_side) {//i < sub_side时，在Len[j]和sub_side - i中取最小值，省去了j的判断
                int j = 2 * sub_midd - i;
                if(j >= 2 * sub_midd - sub_side && Len.get(j) <= sub_side - i){
                    Len.add(Len.get(j));
                }else{
                    Len.add(sub_side - i + 1);
                }
                else//i >= sub_side时，从头开始匹配
                Len.add(1);
            while( (i - Len.get(i) >= 0 && i + Len.get(i) < s_new.size()) && (s_new.get(i - Len.get(i)) == s_new.get(i + Len.get(i))))
                Len.set(i,Len.get(i) + 1);//s_new[i]两端开始扩展匹配，直到匹配失败时停止
            if(Len.get(i) >= Len.get(sub_midd)){//匹配的新回文子串长度大于原有的长度
                sub_side = Len.get(i) + i - 1;
            sub_midd = i;
         }
    }
    sub = s.substring((2*sub_midd - sub_side)/2,sub_side /2);//在s中找到最长回文子串的位置
        return sub;

    }

    public static void main(String[] args) {
        String str="babad";
        System.out.println(longestPalindrome(str));
    }
}
