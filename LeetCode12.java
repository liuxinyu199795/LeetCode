import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode12 {
    //1.暴力法
    /*public String intToRoman(int num) {
        Map<Integer,String> intToString = new HashMap<>();
        intToString.put(1,"I");
        intToString.put(4,"IV");
        intToString.put(5,"V");
        intToString.put(9,"IX");
        intToString.put(10,"X");
        intToString.put(40,"XL");
        intToString.put(50,"L");
        intToString.put(90,"XC");
        intToString.put(100,"C");
        intToString.put(400,"CD");
        intToString.put(500,"D");
        intToString.put(900,"CM");
        intToString.put(1000,"M");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(1000);
        deque.addLast(900);
        deque.addLast(500);
        deque.addLast(400);
        deque.addLast(100);
        deque.addLast(90);
        deque.addLast(50);
        deque.addLast(40);
        deque.addLast(10);
        deque.addLast(9);
        deque.addLast(5);
        deque.addLast(4);
        deque.addLast(1);
        StringBuffer result = new StringBuffer();
        while(num != 0){
            int a = deque.peekFirst();
            if(num < a){
                deque.pollFirst();
            }else{
                num -= a;
                result.append(intToString.get(a));
            }
        }
        return result.toString();
    }*/
    //2.精简版（双数组单独存）
    int[] val = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length && x > 0; i++) {
            int cv = val[i];
            String cs = str[i];
            while (x >= cv) {
                sb.append(cs);
                x -= cv;
            }
        }
        return sb.toString();
    }
}
