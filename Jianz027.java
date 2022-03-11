public class Jianz027 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot == null || (pRoot.left == null && pRoot.right == null)) return pRoot;
        TreeNode node = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = pRoot.left;
        if(pRoot.left != null) Mirror(pRoot.left);
        if(pRoot.right != null) Mirror(pRoot.right);
        return pRoot;
    }
}
