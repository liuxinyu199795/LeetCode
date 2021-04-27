import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode938 {
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
    //1.中序遍历暴力法
    /*List<Integer> result = new ArrayList<>();
    public int rangeSumBST(TreeNode root, int low, int high) {
        midSort(root);
        int sum = 0;
        for (int num : result) {
            if(num >= low && num <= high){
                sum += num;
            }
        }
        return sum;
    }
    public void midSort(TreeNode root){
        if(root == null) return;
        midSort(root.left);
        result.add(root.val);
        midSort(root.right);
    }*/
    //2.中序递归剪枝
    /*int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        midSort(root,low,high);
        return sum;
    }
    public void midSort(TreeNode root,int low,int high){
        if(root == null) return;
        midSort(root.left,low,high);
        if(root.val >= low && root.val <= high) sum += root.val;
        midSort(root.right,low,high);
    }*/
    //3.迭代(栈）(双向链表）
    public int rangeSumBST(TreeNode root, int low, int high) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        int sum = 0;
        while(root != null || !deque.isEmpty()){
            while(root != null){
                deque.addLast(root);
                root = root.left;
            }
            root = deque.pollLast();
            if(root.val <= high && root.val >= low){
                sum += root.val;
            }
            root = root.right;
        }
        return sum;
    }

}
