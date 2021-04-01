/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode173 {
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
  //1.队列处理，存储中序遍历得到的递增数字，然后队列出即可
    /*Deque<Integer> deque = new ArrayDeque<>();
    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    public int next() {
        return deque.pollFirst();
    }

    public boolean hasNext() {
        if(deque.isEmpty()) return false;
        return true;
    }
    public void dfs(TreeNode node){
        if(node==null) return;
        dfs(node.left);
        deque.add(node.val);
        dfs(node.right);
    }*/
    //2.单调栈，把根节点和子节点全部放入栈，依次出栈，如果该节点有右节点，就继续将其作为根节点，把它和左节点们放入栈
    /*LinkedList<TreeNode> stack = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        addNode(root);
    }

    public int next() {
        TreeNode node = stack.pollLast();
        int num = node.val;
        if(node.right!=null){
            addNode(node.right);
        }
        return num;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
    public void addNode(TreeNode node){
        //加入根节点和左子节点
        while(node!=null){
            stack.addLast(node);
            node = node.left;
        }
    }*/
}
