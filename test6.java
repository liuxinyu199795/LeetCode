package GaoPinSuanFa;

public class test6 {
    public static String convert(String s, int numRows) {
        if(s==null||s.length()==0)
            return "";
        if(s.length()<=numRows||numRows==1)
            return s;
        int len =s.length();
        int num =2*numRows-2;//每个部分的长度
        StringBuilder str=new StringBuilder();
        for (int i = 0; i <numRows ; i++) {
            for (int j = i; j <len ; j+=num) {
                str.append(s.charAt(j));
                if(i!=0&&i!=numRows-1&&j+num-2*i<len){
                    str.append(s.charAt(j+num-2*i));
                }
            }
        }
        return str.toString();
    }
    public static void main(String[] args) {
        String str="LEETCODEISHIRING";
        System.out.println(convert(str,3));
        String str1="LEETCODEISHIRING";
        System.out.println(convert(str,4));
    }
}
