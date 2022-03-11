public class Jianz026 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        //如果找到与子树相同根的值，走判断方法
        if(root1.val == root2.val){
            if(judge(root1,root2)) return true;
        }
        //遍历左孩子，右孩子
        return HasSubtree(root1.left,root2) && HasSubtree(root1.right,root2);
    }
    public boolean judge(TreeNode root,TreeNode subTree){
        //子结构已经循环完毕，代表全部匹配
        if(subTree == null) return true;
        //大叔已经循环完毕，并未成功匹配
        if(root == null) return false;
        //相等判断左右孩子是否相等
        if(root.val == subTree.val){
            return judge(root.left,subTree.left) && judge(root.right,subTree.right);
        }
        return false;
    }
}
