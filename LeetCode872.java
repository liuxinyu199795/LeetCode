import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode872 {
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
    //1.DFS深度优先(递归实现）
    /*public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        add(root1,list1);
        add(root2,list2);
        if(list1.size() == list2.size()){
            for (int i = 0; i < list1.size(); i++) {
                if(Integer.compare(list1.get(i),list2.get(i)) != 0){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public void add(TreeNode root,List<Integer> list1){
        if(root == null) return;
        if(root.left == null && root.right == null) {
            list1.add(root.val);
            return;
        }
        add(root.left,list1);
        add(root.right,list1);
    }*/
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        process(list1,root1);
        process(list2,root2);
        if(list1.size() == list2.size()){
            for (int i = 0; i < list1.size(); i++) {
                if(!list1.get(i).equals(list2.get(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    public void process(List<Integer> list,TreeNode root){
        Deque<TreeNode> deque = new ArrayDeque<>();
        while(root != null || !deque.isEmpty()){
            while(root != null){
                deque.addLast(root);
                root = root.left;
            }
            root = deque.pollLast();
            if(root.left == null && root.right == null){
                list.add(root.val);
            }
            root = root.right;
        }
    }
}
