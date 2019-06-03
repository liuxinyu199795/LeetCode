public class LeetCode111 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
    //分治法（对左右两边的最小值比较）
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null) return 1+minDepth(root.right);
        if(root.right==null) return 1+minDepth(root.left);

        int minleft=minDepth(root.left);
        int minright=minDepth(root.right);
        return 1+Math.min(minleft,minright);
    }
    public static void main(String[] args) {

    }
}
