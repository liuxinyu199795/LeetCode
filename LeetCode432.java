import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode432 {
    class Node {
        int cnt;
        Set<String> set = new HashSet<>();
        Node left, right;
        Node(int _cnt) {
            cnt = _cnt;
        }
    }

    Node hh, tt;
    Map<String, Node> map = new HashMap<>();
    public LeetCode432() {
        hh = new Node(-1000); tt = new Node(-1000);
        hh.right = tt; tt.left = hh;
    }

    void clear(Node node) {
        if (node.set.size() == 0) {
            node.left.right = node.right;
            node.right.left = node.left;
        }
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.set.remove(key);
            int cnt = node.cnt;
            Node next = null;
            if (node.right.cnt == cnt + 1) {
                next = node.right;
            } else {
                next = new Node(cnt + 1);
                next.right = node.right;
                next.left = node;
                node.right.left = next;
                node.right = next;
            }
            next.set.add(key);
            map.put(key, next);
            clear(node);
        } else {
            Node node = null;
            if (hh.right.cnt == 1) {
                node = hh.right;
            } else {
                node = new Node(1);
                node.right = hh.right;
                node.left = hh;
                hh.right.left = node;
                hh.right = node;
            }
            node.set.add(key);
            map.put(key, node);
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        node.set.remove(key);
        int cnt = node.cnt;
        if (cnt == 1) {
            map.remove(key);
        } else {
            Node prev = null;
            if (node.left.cnt == cnt - 1) {
                prev = node.left;
            } else {
                prev = new Node(cnt - 1);
                prev.right = node;
                prev.left = node.left;
                node.left.right = prev;
                node.left = prev;
            }
            prev.set.add(key);
            map.put(key, prev);
        }
        clear(node);
    }

    public String getMaxKey() {
        Node node = tt.left;
        for (String str : node.set) return str;
        return "";
    }

    public String getMinKey() {
        Node node = hh.right;
        for (String str : node.set) return str;
        return "";
    }
}
