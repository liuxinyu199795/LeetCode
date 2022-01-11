import java.util.ArrayList;
import java.util.List;

public class Jianz008 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }
    List<TreeLinkNode> list = new ArrayList<>();
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode root = null,tmp = pNode;
        while(pNode.next != null){
            pNode = pNode.next;
        }
        root = pNode;//根结点
        add(root);
        for(int i=0;i<list.size();i++){
            if(tmp == list.get(i)){
                return i == list.size()-1?null:list.get(i+1);
            }
        }
        return null;
    }
    public void add(TreeLinkNode root){
        if(root == null){
            return;
        }
        add(root.left);
        list.add(root);
        add(root.right);
    }
}
