package GaoPinSuanFa;


import java.util.HashMap;
import java.util.Map;

public class test13 {
    public static int romanToInt(String s) {
        Map<String,Integer> a = new HashMap<String, Integer>();
        a.put("I",1);
        a.put("IV", 4);
        a.put("V", 5);
        a.put("IX", 9);
        a.put("X", 10);
        a.put("XL", 40);
        a.put("L", 50);
        a.put("XC", 90);
        a.put("C", 100);
        a.put("CD", 400);
        a.put("D", 500);
        a.put("CM", 900);
        a.put("M", 1000);
        int len = s.length();
        int result = 0;
        if("".equals(s)||s==null){
            return 0;
        }
        for (int i = 0; i < len; i++) {
            if (i + 1 < len && a.containsKey(s.substring(i, i + 2))) {
                result = result + a.get(s.substring(i, i + 2));
                i++;
            }else if(a.containsKey(String.valueOf(s.charAt(i)))){
                result = result + a.get(String.valueOf(s.charAt(i)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String num="MCMXCIV";
        System.out.println(romanToInt(num));
    }
}
