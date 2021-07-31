/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode671 {public class TreeNode {
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
    int ans = -1;
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return ans;
    }
    void dfs(TreeNode root, int cur) {
        if (root == null) return ;
        if (root.val != cur) {
            if (ans == -1) ans = root.val;
            else ans = Math.min(ans, root.val);
            return ;
        }
        dfs(root.left, cur);
        dfs(root.right, cur);
    }
}
