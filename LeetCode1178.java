import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1178 {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 首先计算每个word出现次数，使用二进制状态压缩每个word
        for (String word : words) {
            int mask = getBitMask(word);
            // 如果包含的字符数量大于7，那么一定无法作为谜底，无需加入映射表
            if (Integer.bitCount(mask) <= 7) {
                map.put(mask, map.getOrDefault(mask, 0) + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (String puzzle : puzzles) {
            int cnt = 0;

            // 第一个字符必须存在，先获取第一个字符的二进制码
            int first = getBitMask(puzzle.substring(0, 1));
            // 获取后面字符串的二进制码
            int mask = getBitMask(puzzle.substring(1));
            int subset = mask;
            // 枚举后面字符串子集
            while (subset != 0) {
                int key = first | subset;
                if (map.containsKey(key)) {
                    cnt += map.get(key);
                }
                subset = (subset - 1) & mask;
            }
            // 后面字符串为空的情况
            if (map.containsKey(first)) {
                cnt += map.get(first);
            }
            ans.add(cnt);
        }
        return ans;
    }

    private int getBitMask(String word) {
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            mask |= (1 << (ch - 'a'));
        }
        return mask;
    }
}
