import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode692 {
    public List<String> topKFrequent(String[] ws, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : ws) map.put(w, map.getOrDefault(w, 0) + 1);
        PriorityQueue<Object[]> q = new PriorityQueue<>(k, (a, b)->{
            // 如果词频不同，根据词频升序
            int c1 = (Integer)a[0], c2 = (Integer)b[0];
            if (c1 != c2) return c1 - c2;
            // 如果词频相同，根据字典序倒序
            String s1 = (String)a[1], s2 = (String)b[1];
            return s2.compareTo(s1);
        });
        for (String s : map.keySet()) {
            int cnt = map.get(s);
            if (q.size() < k) { // 不足 k 个，直接入堆
                q.add(new Object[]{cnt, s});
            } else {
                Object[] peek = q.peek();
                if (cnt > (Integer)peek[0]) { // 词频比堆顶元素大，弹出堆顶元素，入堆
                    q.poll();
                    q.add(new Object[]{cnt, s});
                } else if (cnt == (Integer)peek[0]) { // 词频与堆顶元素相同
                    String top = (String)peek[1];
                    if (s.compareTo(top) < 0) { // 且字典序大小比堆顶元素小，弹出堆顶元素，入堆
                        q.poll();
                        q.add(new Object[]{cnt, s});
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>();
        while (!q.isEmpty()) ans.add((String)q.poll()[1]);
        Collections.reverse(ans);
        return ans;
    }

}
