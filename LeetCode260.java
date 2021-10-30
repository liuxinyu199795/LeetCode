import java.util.HashMap;
import java.util.Map;

public class LeetCode260 {
    //1.哈希表
    /*public int[] singleNumber(int[] nums) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        int i = 0;
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1) res[i++] = entry.getKey();
        }
        return res;
    }*/
    //2.异或
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) sum ^= i;
        //找出sum二进制为任意为1的一位，代表两答案的第k位不同
        int k = -1;
        for (int i = 31; i >= 0 && k == -1 ; i++) {
            if(((sum >> i) & 1) == 1) k = i;
        }
        //对num进行遍历，针对第k位为0和1的数分别进行异或，结果即为两个答案
        int[] res = new int[2];
        for (int num : nums) {
            if(((num >> k) & 1) == 1) res[0] ^= num;
            else res[1] ^= num;
        }
        return res;
    }
}
