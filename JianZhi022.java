import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi022 {
    //1.DFS(队列）
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }

    }
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while(!deque.isEmpty()){
            TreeNode node = deque.pollFirst();
            list.add(node.val);
            if(node.left != null) deque.addLast(node.left);
            if(node.right != null) deque.addLast(node.right);
        }
        return list;
    }
}
