/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode897 {
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
    //1.中序遍历（左跟右）
    TreeNode result = null;
    TreeNode pre;
    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return result;
        binarySearch(root);
        return pre;
    }
    public void binarySearch(TreeNode treeNode){
        if(treeNode == null) return;
        binarySearch(treeNode.left);
        if(result == null){
           result = new TreeNode(treeNode.val);
           pre = result;
        }else {
            result.left = null;
            result.right = new TreeNode(treeNode.val);
            result = result.right;
        }
        binarySearch(treeNode.right);
    }
}
