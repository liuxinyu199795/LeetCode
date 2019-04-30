public class LeetCode43 {
    public static String multiply(String num1, String num2) {
        int[] num =new int[num1.length()+num2.length()];
        for (int i = num1.length()-1; i >=0; i--) {
            for (int j = num2.length()-1; j >=0; j--) {
                int a=num1.charAt(i)-'0';
                int b=num2.charAt(j)-'0';
                num[i+j+1]+=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            }
        }
        //处理进位
        int temp=0;
        for (int i =num.length-1; i>=0 ; i--) {
            num[i]+=temp;
            temp=num[i]/10;
            num[i]%=10;
        }
        //处理最前面的0
        int a=0;
        while(a<num.length-1&&num[a]==0){
            a++;
        }
        String s="";
        for (int i = a; i <num.length ; i++) {
            s+=num[i];
        }
        return s;
    }


    public static void main(String[] args) {
        System.out.println(multiply("1234","25"));
    }
}
