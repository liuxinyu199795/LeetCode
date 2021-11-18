public class LeetCode563 {
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
   //递归
   int ans;
    public int findTilt(TreeNode root) {
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode node){
        if(node == null) return 0;
        int l = dfs(node.left), r = dfs(node.right);
        ans += Math.abs(l - r);
        return l + r + node.val;
    }
}
