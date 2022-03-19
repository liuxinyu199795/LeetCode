/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode606 {
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
   StringBuffer sb = new StringBuffer();
    public String tree2str(TreeNode root) {
        dfs(root);
        return sb.substring(1,sb.length() - 1);
    }
    public void dfs(TreeNode node){
        sb.append("(");
        sb.append(node.val);
        if(node.left != null) dfs(node.left);
        else if(node.right != null) sb.append("()");
        if(node.right != null) dfs(node.right);
        sb.append(")");
    }
}
