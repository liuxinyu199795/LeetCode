import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode1418 {
    //1.暴力法（Map排序用TreeMap,Set用TreeSet
    public static List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer,Map<String,Integer>> tableMap = new TreeMap<>();
        Set<String> foodList = new TreeSet<>();
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            foodList.add(food);
            Map<String, Integer> foodMap = tableMap.getOrDefault(table, new HashMap<>());
            foodMap.put(food,foodMap.getOrDefault(food,0) + 1);
            tableMap.put(table,foodMap);
        }
        List<List<String>> result = new ArrayList<>();
        List<String> relFood = new ArrayList<>();
        relFood.add("Table");
        for (String f : foodList) {
            relFood.add(f);
        }
        result.add(relFood);
        for (Map.Entry<Integer,Map<String,Integer>> entry : tableMap.entrySet()) {
            List<String> number = new ArrayList<>();
            number.add(entry.getKey().toString());
            Map<String,Integer> value = entry.getValue();
            for (String f : foodList) {
                int tmp = value.get(f) != null ? value.get(f) : 0;
                number.add(String.valueOf(tmp));
            }
           result.add(number);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("David","3","Ceviche"));
        List<String> list2 = new ArrayList<>(Arrays.asList("Corina","10","Beef Burrito"));
        List<String> list3 = new ArrayList<>(Arrays.asList("David","3","Fried Chicken"));
        List<String> list4 = new ArrayList<>(Arrays.asList("Carla","5","Water"));
        List<String> list5 = new ArrayList<>(Arrays.asList("Carla","5","Ceviche"));
        List<String> list6 = new ArrayList<>(Arrays.asList("Rous","3","Ceviche"));
        List<List<String>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        list.add(list5);
        list.add(list6);
        displayTable(list);
    }
}
