import java.util.*;

public class LeetCode230 {
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
   //1.树的遍历
//    List<Integer> list = new ArrayList<>();
//    public int kthSmallest(TreeNode root, int k) {
//        dfs(root);
//        Collections.sort(list);
//        return list.get(k - 1);
//    }
//    void dfs(TreeNode root){
//        if(root == null) return;
//        list.add(root.val);
//        dfs(root.left);
//        dfs(root.right);
//    }
    //2.中序遍历
   public int kthSmallest(TreeNode root, int k) {
       Deque<TreeNode> d = new ArrayDeque<>();
       while(root != null || !d.isEmpty()){
           while(root != null){
               d.addLast(root);
               root = root.left;

           }
           root = d.pollLast();
           if(--k == 0) return root.val;
           root = root.right;
       }
       return -1;
   }
}
