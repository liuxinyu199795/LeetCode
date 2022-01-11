import java.util.Arrays;

public class Jianz007 {
   public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
    public TreeNode reConstructBinaryTree(int [] pre,int [] vin) {
        if(pre.length == 0 || vin.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < vin.length; i++) {
            if(vin[i] == pre[0]){
                root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,i + 1),Arrays.copyOfRange(vin,0,i));
                root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,i + 1,pre.length),Arrays.copyOfRange(vin,i + 1,vin.length));
                break;
            }
        }
        return root;
    }
}
