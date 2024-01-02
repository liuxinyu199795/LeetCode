import java.util.ArrayList;
import java.util.List;

public class LeetCode94 {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recur(root,list);
        return list;
    }
    private void recur(TreeNode node,List<Integer> res){
        if(node == null){
            return;
        }
        recur(node.left,res);
        res.add(node.val);
        recur(node.right,res);
    }
}
