public class Jianz036 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    TreeNode pre = null;//第一个指针
    TreeNode node = null;//随着递归移动的指针
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        Convert(pRootOfTree.left);
        if(pre == null){
            pre = pRootOfTree;
            node = pRootOfTree;
        }else{
            node.right = pRootOfTree;
            pRootOfTree.left = node;
            node = pRootOfTree;
        }
        Convert(pRootOfTree.right);
        return pre;
    }
}
