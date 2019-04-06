package GaoPinSuanFa;


import javafx.beans.binding.StringBinding;

import java.util.Map;

public class test12 {
    public static String intToRoman(int num) {
        int[] num1=new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str=new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder str1=new StringBuilder();
        for (int i = 0; i <num1.length ; i++) {
            while(num>=num1[i]){
                num=num-num1[i];
                str1.append(str[i]);
            }
        }
        return String.valueOf(str1);
    }

    public static void main(String[] args) {
        int num= 27;
        System.out.println(intToRoman(num));
    }
}
