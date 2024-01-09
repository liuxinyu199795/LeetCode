import java.util.*;

public class Test {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        int iLength = matrix.length,jLength = matrix[0].length,i = 0,j = 0;
        boolean[][] valid = new boolean[iLength][jLength];
        int total  = iLength * jLength;
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        int directionIndex = 0;
        for (int k = 0; k < total; k++) {
            res.add(matrix[i][j]);
            valid[i][j] = true;
            int nextI = i + directions[directionIndex][0],nextJ = j + directions[directionIndex][1];
            if(nextI < 0 || nextI >= iLength || nextJ < 0 || nextJ >= jLength || valid[nextI][nextJ]){
                directionIndex = (directionIndex + 1) % 4;//超过了就换个方向（%4是为了重新开始顺时针）
            }
            i += directions[directionIndex][0];
            j += directions[directionIndex][1];
        }
        return res;
    }
    public void rotate(int[][] matrix) {
        int[][] tmp = new int[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            tmp[i] = matrix[i].clone();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][matrix.length - 1 - i] = tmp[i][j];
            }
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length,n = matrix[0].length;
        int i = 0,j = matrix[0].length - 1;
        while(i < m && j >= 0){
            if(matrix[i][j] < target){
                i++;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                return true;
            }
        }
        return false;
    }

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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long lower,long upper){
        if(root == null){
            return true;
        }
        if(root.val <= lower || root.val >= upper){
            return false;
        }
        return isValidBST(root.left,lower,root.val) && isValidBST(root.right,root.val,upper);
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> deque = new Stack<>();
        while(root != null || !deque.isEmpty()){
            while(root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            k--;
            if(k == 0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long,Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0l,1);
        return recur(root,prefixSumCount,targetSum,0l);
    }
    private int recur(TreeNode node,Map<Long,Integer> prefixSumCountMap,int target,long currSum){
        if(node == null){
            return 0;
        }
        int res = 0;
        currSum += node.val;
        res += prefixSumCountMap.getOrDefault(currSum - target,0);
        prefixSumCountMap.put(currSum,prefixSumCountMap.getOrDefault(currSum,0) + 1);//更新路径商当前节点前缀和的个数，为了后续层
        res += recur(node.left,prefixSumCountMap,target,currSum);
        res += recur(node.right,prefixSumCountMap,target,currSum);
        prefixSumCountMap.put(currSum,prefixSumCountMap.get(currSum) - 1);//回到本层，恢复状态
        return res;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null) return null;
        if(left == null) return right;
        if(right == null) return left;
        return root;
    }
}
