public class LeetCode235 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val>root.val&&q.val>root.val){//如果都大于，则最近的一定在root的右子树里，继续找
            return lowestCommonAncestor(root.right,p,q);
        }else if(p.val<root.val&&q.val<root.val){ //如果都小于，则最近的一定在root的左子树里，继续找
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;//如果一左一右就直接返回root
    }
    public static void main(String[] args) {

    }
}
