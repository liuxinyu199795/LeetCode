import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class JianZhi004 {
    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
   //1.递归
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        int root = preorder[0];
        TreeNode node = new TreeNode(root);
        for (int i = 0; i < inorder.length; i++) {
            if(inorder[i] == root){
                node.left = buildTree(Arrays.copyOfRange(preorder,1,i + 1),Arrays.copyOfRange(inorder,0,i));
                node.right = buildTree(Arrays.copyOfRange(preorder,i + 1,preorder.length),Arrays.copyOfRange(inorder,i + 1,inorder.length));
            }
        }
        return node;
    }
}
