import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode590 {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        dfs(root);
        return ans;

    }
    void dfs(Node root){
        if(root == null) return;
        for (Node node : root.children) {
            dfs(node);
        }
        ans.add(root.val);
    }
}
