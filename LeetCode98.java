import java.util.ArrayList;
import java.util.List;

public class LeetCode98 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
    public static boolean isValidBST(TreeNode root) {
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
    }
    public static void main(String[] args) {

    }
}
