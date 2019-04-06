package GaoPinSuanFa;

public class test14 {
    public static String longestCommonPrefix(String[] strs) {
        int length=strs.length;
        if(length==0) return "";
        String str=new String();
        str=strs[0];
        for (int i = 1; i <length ; i++) {
            while(strs[i].indexOf(str)!=0){
                str=str.substring(0,str.length()-1);
                if(str.length()==0) return "";
            }
        }
        return str;
    }
    public static void main(String[] args) {
        String[] num={"abcc","abcd","abcde"};
        System.out.println(longestCommonPrefix(num));
    }
}
