import java.util.ArrayDeque;
import java.util.Queue;

public class LeetCode114 {
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
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        sort(root,queue);
        queue.poll();
        while(!queue.isEmpty()){
            root.left = null;
            root.right = new TreeNode(queue.poll());
            root = root.right;
        }
    }
    public void sort(TreeNode node,Queue<Integer> queue){
        if(node == null){
            return;
        }
        queue.offer(node.val);
        sort(node.left,queue);
        sort(node.right,queue);
    }
}
