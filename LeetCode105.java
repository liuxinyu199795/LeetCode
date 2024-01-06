import java.util.HashMap;
import java.util.Map;

public class LeetCode105 {
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
   //1.递归
    Map<Integer,Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i],i);
        }
         return buildTree(preorder,inorder,0,length - 1,0,length - 1);
    }
    public TreeNode buildTree(int[] preorder,int[] inorder,int pre_i,int pre_j,int in_i,int in_j){
        if(pre_i > pre_j){
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_i]);

        int rootIndex = map.get(preorder[pre_i]);
        int size_leftTree = rootIndex - in_i;
        root.left = buildTree(preorder,inorder,pre_i + 1,pre_i + size_leftTree,in_i,rootIndex - 1);
        root.right = buildTree(preorder,inorder,pre_i + size_leftTree + 1,pre_j,rootIndex + 1,in_j);
        return root;
    }
}
