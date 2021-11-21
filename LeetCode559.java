import java.util.List;

public class LeetCode559 {
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
    }
    public int maxDepth(Node root) {
        if(root == null) return 0;
        int ans = 0;
        for (Node node : root.children) {
            ans = Math.max(ans,maxDepth(node));
        }
        return ans + 1;
    }
}
