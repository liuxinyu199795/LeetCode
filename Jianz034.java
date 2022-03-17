import java.util.ArrayList;

public class Jianz034 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }

    }
    //递归+回溯（一个存路径的list，不满足情况就回溯去查找另一条路径
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int expectNumber) {
        dfs(root,0,expectNumber,new ArrayList<>());
        return res;
    }
    public void dfs(TreeNode node,int num,int expect,ArrayList<Integer> list){
        if(node == null) return;
        int val = node.val + num;
        list.add(node.val);
        if(node.left == null && node.left == null && val == expect){
            res.add(new ArrayList<>(list));
        }
        if(node.left != null) dfs(node.left,val,expect,list);
        if(node.right != null) dfs(node.right,val,expect,list);
        list.remove(list.size() - 1);
    }
}
