import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode993 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> tmp = new ArrayDeque<>();
        if(root == null) return false;
        int a = 0,b = 0,i = 1;
        queue.addLast(root);
        while(!queue.isEmpty() || !tmp.isEmpty()){
            if(queue.isEmpty()){
                i++;
                while(!tmp.isEmpty()){
                    queue.addLast(tmp.pollFirst());
                }
            }
            TreeNode node = queue.pollFirst();
            if(node.val == x){
                a = i;
            }
            if(node.val == y){
                b = i;
            }
            if(node.left != null){
                tmp.addLast(node.left);
            }
            if(node.right != null){
                tmp.addLast(node.right);
            }
        }
        return a == b;
    }
}
