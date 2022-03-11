import java.util.Stack;

public class Jianz027 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
    //1.递归
    /*public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot == null || (pRoot.left == null && pRoot.right == null)) return pRoot;
        TreeNode node = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = pRoot.left;
        if(pRoot.left != null) Mirror(pRoot.left);
        if(pRoot.right != null) Mirror(pRoot.right);
        return pRoot;
    }*/
    //2.辅助栈
    public TreeNode Mirror (TreeNode pRoot) {
        if(pRoot == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(pRoot);
        while(!stack.isEmpty()){
            TreeNode tmp = stack.pop();
            if(tmp.left != null){
                stack.add(tmp.left);
            }
            if(tmp.right != null){
                stack.add(tmp.right);
            }
            TreeNode node = tmp.left;
            tmp.left = tmp.right;
            tmp.right = node;
        }
        return pRoot;
    }
}
