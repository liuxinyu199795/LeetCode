public class LeetCode108 {
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return sorted(nums,0,nums.length - 1);
    }
    private TreeNode sorted(int[] nums,int i,int j){
        if(i > j){
            return null;
        }
        int mid = (i + j) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sorted(nums,i,mid - 1);
        node.right = sorted(nums,mid + 1,j);
        return node;
    }
}
