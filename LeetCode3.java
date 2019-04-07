package GaoPinSuanFa;

public class test3 {
    public static void main(String[] args) {
        String s="abcabcbb";
        System.out.println(length(s));
    }
    public static int length(String s){
        char[] chars =s.toCharArray();
        int num=0;
        for (int i = 0; i < chars.length; i++) {
            int a=1;
            a:for(int j=i+1;j< chars.length;j++){
                for (int k = i; k <j ; k++) {
                    if(chars[j]==chars[k]){
                        break a;
                    }
                }
                a++;
            }
            if(a>num){
                num=a;
            }
        }
        return num;
    }
}
