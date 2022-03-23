import java.util.ArrayDeque;
import java.util.Queue;

public class Jianz037 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    int index = -1;
    StringBuffer sb = new StringBuffer();
    String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }else{
            return root.val + "," + Serialize(root.left) + "," + Serialize(root.right);
        }
    }
    TreeNode Deserialize(String str) {
        String[] s = str.split(",");
        index++;
        int len = s.length;
        if(index > len){
            return null;
        }
        TreeNode treeNode = null;//如果为#，则为null
        if(!s[index].equals("#")){
            treeNode = new TreeNode(Integer.parseInt(s[index]));
            treeNode.left = Deserialize(str);
            treeNode.right = Deserialize(str);
        }
        return treeNode;
    }
}
