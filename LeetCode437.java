public class LeetCode437 {
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
    //1.dfs
    int ans = 0,_target = 0;
    public int pathSum(TreeNode root, int targetSum) {
        _target = targetSum;
        dfs(root);
        return ans;
    }
    public void dfs(TreeNode root){
     if(root == null) return;
      dfs2(root,root.val);
      dfs(root.left);
      dfs(root.right);
    }
    public void dfs2(TreeNode root,int val){
     if(val == _target) ans++;
     if(root.left != null) dfs2(root.left,val + root.left.val);
     if(root.right != null) dfs2(root.right,val + root.right.val);
    }
}
