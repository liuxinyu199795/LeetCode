public class Jianz028 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    boolean isSymmetrical(TreeNode pRoot) {
        if(pRoot == null) return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }
    boolean isSymmetrical(TreeNode left,TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val == right.val){
            return isSymmetrical(left.right,right.left) && isSymmetrical(left.left,right.right);
        }
        return false;
    }
}
