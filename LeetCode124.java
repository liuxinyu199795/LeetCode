public class LeetCode124 {
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
   int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        rec(root);
        return maxSum;
    }
    public int rec(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = Math.max(rec(node.left),0);//大于0才取
        int right = Math.max(rec(node.right),0);//大于0才取
        int value = node.val + left + right;//算出根结点跟左右节点的最大值
        maxSum = Math.max(maxSum,value);//算出全局最大贡献值
        return node.val + Math.max(left,right);//返回节点的最大贡献值
    }
}
