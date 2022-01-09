import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Jianz003 {
    /*public int duplicate (int[] numbers) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : numbers) {
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            if(entry.getValue() == 2){
                return entry.getKey();
            }
        }
        return -1;
    }*/
    public int duplicate (int[] numbers) {
        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length; i++) {
            if(numbers[i - 1] == numbers[i]){
                return numbers[i];
            }
        }
        return -1;
    }
}
