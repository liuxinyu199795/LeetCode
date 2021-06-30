import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi061 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
    }
    //1.DFS（递归）
    int index = -1;
    StringBuffer sb = new StringBuffer();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "#";
        }else{
            return root.val + "," + serialize(root.left) + "," + serialize(root.right);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        index++;
        int len = str.length;
        if(index > len){
            return null;
        }
        TreeNode node = null;
        if(!str[index].equals("#")){
            node = new TreeNode(Integer.valueOf(str[index]));
            node.left = deserialize(data);
            node.right = deserialize(data);
        }
        return node;
    }
    //2.BFS（队列）
    /*int INF = -2000;
    TreeNode emptyNode = new TreeNode(INF);
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            TreeNode poll = d.pollFirst();
            sb.append(poll.val + "_");
            if (!poll.equals(emptyNode)) {
                d.addLast(poll.left != null ? poll.left : emptyNode);
                d.addLast(poll.right != null ? poll.right : emptyNode);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        String[] ss = data.split("_");
        int n = ss.length;
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        for (int i = 1; i < n - 1; i += 2) {
            TreeNode poll = d.pollFirst();
            int a = Integer.parseInt(ss[i]), b = Integer.parseInt(ss[i + 1]);
            if (a != INF) {
                poll.left = new TreeNode(a);
                d.addLast(poll.left);
            }
            if (b != INF) {
                poll.right = new TreeNode(b);
                d.addLast(poll.right);
            }
        }
        return root;
    }*/
}
