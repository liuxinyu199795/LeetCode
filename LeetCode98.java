import java.util.ArrayList;
import java.util.List;

public class LeetCode98 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
    /*public static boolean isValidBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if(root==null) return true;
        orderBST(root,list);
        for (int i = 0; i <list.size()-1 ; i++) {
            if (list.get(i).val >= list.get(i + 1).val) return false;
        }
        return true;
    }
    //中序遍历
    public static void orderBST(TreeNode root,List<TreeNode> list){
        if(root==null) return;
        orderBST(root.left,list);
        list.add(root);
        orderBST(root.right,list);
    }*/

    //左子树的最大值<根节点<右子树的最小值
    public static boolean isValidBST(TreeNode root){
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;
        return validBST(root,min,max);
    }
    public static boolean validBST(TreeNode root,Integer min,Integer max){
        if(root==null){
            return true;
        }else if(min>=root.val&&min!=null){
            return false;
        }else if(max<=root.val&&max!=null){
            return false;
        }
        return validBST(root.left,min,root.val)&&validBST(root.right, root.val,max);
    }
    public static void main(String[] args) {

    }
}
