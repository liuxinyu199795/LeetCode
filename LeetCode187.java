import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode187 {
    //1.滑动窗口+hash表
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String,Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String str = s.substring(i,i + 10);
            int len = map.getOrDefault(str,0);
            if(len == 1) result.add(str);
            map.put(str,len + 1);
        }
        return result;
    }
}
