import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode726 {
    class Node {
        String s; int v;
        Node (String _s, int _v) {
            s = _s; v = _v;
        }
    }
    //1.栈+分类讨论+哈希计数+优先队列
    public String countOfAtoms(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        Deque<String> d = new ArrayDeque<>();
        int idx = 0;
        for (int i = 0; i < n; ) {
            char c = cs[i];
            if (c == '(' || c == ')') {
                d.addLast(String.valueOf(c));
                i++;
            } else {
                if (Character.isDigit(c)) {
                    // 获取完整的数字，并解析出对应的数值
                    int j = i;
                    while (j < n && Character.isDigit(cs[j])) j++;
                    String numStr = s.substring(i, j);
                    i = j;
                    int cnt = Integer.parseInt(String.valueOf(numStr));

                    // 如果栈顶元素是 )，说明当前数值可以应用给「连续一段」的原子中
                    if (!d.isEmpty() && d.peekLast().equals(")")) {
                        List<String> tmp = new ArrayList<>();

                        d.pollLast(); // pop )
                        while (!d.isEmpty() && !d.peekLast().equals("(")) {
                            String cur = d.pollLast();
                            map.put(cur, map.getOrDefault(cur, 1) * cnt);
                            tmp.add(cur);
                        }
                        d.pollLast(); // pop (

                        for (int k = tmp.size() - 1; k >= 0; k--) {
                            d.addLast(tmp.get(k));
                        }

                        // 如果栈顶元素不是 )，说明当前数值只能应用给栈顶的原子
                    } else {
                        String cur = d.pollLast();
                        map.put(cur, map.getOrDefault(cur, 1) * cnt);
                        d.addLast(cur);
                    }
                } else {
                    // 获取完整的原子名
                    int j = i + 1;
                    while (j < n && Character.isLowerCase(cs[j])) j++;
                    String cur = s.substring(i, j) + "_" + String.valueOf(idx++);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                    i = j;
                    d.addLast(cur);
                }
            }
        }

        // 将不同编号的相同原子进行合并
        Map<String, Node> mm = new HashMap<>();
        for (String key : map.keySet()) {
            String atom = key.split("_")[0];
            int cnt = map.get(key);
            Node node = null;
            if (mm.containsKey(atom)) {
                node = mm.get(atom);
            } else {
                node = new Node(atom, 0);
            }
            node.v += cnt;
            mm.put(atom, node);
        }

        // 使用优先队列（堆）对 Node 进行字典序排序，并构造答案
        PriorityQueue<Node> q = new PriorityQueue<Node>((a, b)->a.s.compareTo(b.s));
        for (String atom : mm.keySet()) q.add(mm.get(atom));

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Node poll = q.poll();
            sb.append(poll.s);
            if (poll.v > 1) sb.append(poll.v);
        }

        return sb.toString();
    }
}
