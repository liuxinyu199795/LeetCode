import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1600 {
    String kingName;
    Map<String,String> relationMap = new HashMap<>();
    Map<String,Integer> deathMap = new HashMap<>();
    //Queue<String> queue = new ArrayDeque<>();
    public LeetCode1600(String kingName) {
        this.kingName = kingName;
    }

    public void birth(String parentName, String childName) {
        relationMap.put(parentName,relationMap.containsKey(parentName)
                ? relationMap.get(parentName) + "." + childName : childName);
    }

    public void death(String name) {
        deathMap.put(name,1);
    }
    //bfs广度优先(队列)
    /*public List<String> getInheritanceOrder() {
        List<String> inheritanceOrder = new ArrayList<>();
        queue.add(kingName);
        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(!deathMap.containsKey(cur)) inheritanceOrder.add(cur);
            if(relationMap.containsKey(cur)){
                String[] strings = relationMap.get(cur).split("\\.");
                for (String str : strings) {
                    queue.add(str);
                }
            }
        }
        return inheritanceOrder;
    }*/
    //2.DFS(深度优先-递归)
    public List<String> getInheritanceOrder() {
        List<String> inheritanceOrder = new ArrayList<>();
        recur(inheritanceOrder,kingName);
        return inheritanceOrder;
    }
    public void recur(List<String> inheritanceOrder,String name){
        if(!deathMap.containsKey(name)) inheritanceOrder.add(name);
        if(!relationMap.containsKey(name)) return;
        String[] strings = relationMap.get(name).split("\\.");
        for (String str : strings) {
            recur(inheritanceOrder,str);
        }
    }
}
