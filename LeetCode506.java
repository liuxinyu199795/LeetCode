import java.util.*;

public class LeetCode506 {
    public String[] findRelativeRanks(int[] score) {
        int length = score.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(i, score[i]);
        }
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        String[] result = new String[length];
        for (int i = 0; i < length; i++) {
            if(i == 0){
                result[list.get(i).getKey()] = "Gold Medal";
            }else if(i == 1){
                result[list.get(i).getKey()] = "Silver Medal";
            }else if(i == 2){
                result[list.get(i).getKey()] = "Bronze Medal";
            }else{
                result[list.get(i).getKey()] = String.valueOf(i + 1);
            }
        }
        return result;
    }
}
