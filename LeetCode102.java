import java.util.*;

public class LeetCode102 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
    //1.BFS广度优先搜索
    /*public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> cur = new ArrayList<>();

            for (int i = 0; i <size ; i++) {
                TreeNode p = queue.poll();
                cur.add(p.val);
                if(p.left!=null){
                    queue.add(p.left);
                }
                if(p.right!=null){
                    queue.add(p.right);
                }
            }
            list.add(cur);
        }
        return list;
    }*/

    //2.DFS深度优先搜索
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        Map<Integer,List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> listMap = dfsOrder(root, map, 0);
        for (Map.Entry<Integer,List<Integer>> listEntry:listMap.entrySet()){
            list.add(listEntry.getValue());
        }
        return list;
    }
    public static Map<Integer,List<Integer>> dfsOrder(TreeNode node, Map<Integer,List<Integer>> map, int deep){
        if(node==null) return map;
        if(map.size()<deep+1){
            map.put(deep,new ArrayList<>());
        }
        List<Integer> list = map.get(deep);
        list.add(node.val);
        map.put(deep,list);

        dfsOrder(node.left,map,deep+1);
        dfsOrder(node.right,map,deep+1);
        return map;
    }
    public static void main(String[] args) {

    }
}
