import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class MianShi1002 {
    //1.哈希法
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> list = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String arrayString = String.valueOf(array);
            List<String> list1 = list.getOrDefault(arrayString, new ArrayList<>());
            list1.add(str);
            list.put(arrayString,list1);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String,List<String>> entry : list.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }
}
