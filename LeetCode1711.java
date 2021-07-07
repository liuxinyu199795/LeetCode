import com.sun.corba.se.spi.presentation.rmi.IDLNameTranslator;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1711 {
    static int mod = (int)1e9+7;
    //1.暴力法
    public static int countPairs(int[] deliciousness) {
        Map<Integer, Integer> number = new HashMap<>();
        for (int num : deliciousness) {
            number.put(num,number.getOrDefault(num,0) + 1);
        }
        long res = 0;
        for (Map.Entry<Integer,Integer> entry : number.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            for (Map.Entry<Integer,Integer> entry1 : number.entrySet()) {
                if(key == entry1.getKey() && value > 1){
                    int k = key + entry1.getKey();
                    if(k > 0 && ((k & (k - 1)) == 0)){
                        res += (value - 1) * 1l *entry1.getValue();
                    }
                }else if(key != entry1.getKey()){
                    int k = key + entry1.getKey();
                    if(k > 0 && ((k & (k - 1)) == 0)){
                        res += value * 1l * entry1.getValue();
                    }
                }
            }
        }
        res >>= 1;
        return (int)(res % mod);
    }
    //2.遍历2的平方，看map中是否有等于2的平方-这个数的值
    /*int mod = (int)1e9+7;
    int max = 1 << 22;
    public int countPairs(int[] ds) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : ds) map.put(d, map.getOrDefault(d, 0) + 1);
        long ans = 0;
        for (int x : map.keySet()) {
            for (int i = 1; i < max; i <<= 1) {
                int t = i - x;
                if (map.containsKey(t)) {
                    if (t == x) ans += (map.get(x) - 1) * 1L * map.get(x);
                    else ans += map.get(x) * 1L * map.get(t);
                }
            }
        }
        ans >>= 1;
        return (int)(ans % mod);
    }*/

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,3,3,3,7};
        countPairs(nums);
    }
}
