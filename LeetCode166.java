import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode166 {





    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator,b = denominator;
        if(a % b == 0) return String.valueOf(a / b);
        StringBuilder sb = new StringBuilder();
        if(a * b < 0) sb.append("-");//如果有负数，则添加负号
        a = Math.abs(a);b = Math.abs(b);
        sb.append(String.valueOf(a / b) + ".");//小数点前
        a %= b;
        Map<Long,Integer> map = new HashMap<>();
        while (a != 0){
            // 记录当前余数所在答案的位置，并继续模拟除法运算
            map.put(a,sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            // 如果当前余数之前出现过，则将 [出现位置 到 当前位置] 的部分抠出来（循环小数部分）
            if(map.containsKey(a)){
                int u = map.get(a);
                return String.format("%s(%s)",sb.substring(0,u),sb.substring(u));
            }
        }
        return sb.toString();
    }
}
