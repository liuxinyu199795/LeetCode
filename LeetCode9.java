package GaoPinSuanFa;

public class test9 {
    public static boolean isPalindrome(int x) {
        int a=0;
        int b=0;
        int c=x;
        if(x>0){
            while(x!=0){
                b=x%10;
                x=x/10;
                a=a*10+b;
            }
            if(a==c){
                return true;
            }else{
                return false;
            }
        }else if(x==0){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        int num=121;
        System.out.println(isPalindrome(num));
    }
}
