public class LeetCode226 {
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

    public TreeNode invertTree(TreeNode root) {
        reverse(root);
        return root;
    }
    private void reverse(TreeNode node){
        if(node == null){
            return;
        }
        reverse(node.left);
        reverse(node.right);
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }
}
