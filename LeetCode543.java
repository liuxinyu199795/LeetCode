public class LeetCode543 {
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
    int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        int ans = 1;
        depth(root);
        return ans - 1;
    }
    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = depth(node.left);
        int right = depth(node.right);
        ans = Math.max(ans,left + right + 1);
        return Math.max(left,right) + 1;
    }
}
