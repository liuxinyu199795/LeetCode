import java.util.HashMap;
import java.util.Map;

public class LeetCode299 {
    public static String getHint(String secret, String guess) {
        int bulls = 0,cows = 0;
        Map<Character,Integer> mapA = new HashMap<>();
        Map<Character,Integer> mapB = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                bulls++;
                continue;
            }
            mapA.put(secret.charAt(i),mapA.getOrDefault(secret.charAt(i),0) + 1);
            mapB.put(guess.charAt(i),mapB.getOrDefault(guess.charAt(i),0) + 1);
        }
        StringBuilder sb = new StringBuilder().append(bulls).append("A");
        for (Map.Entry<Character,Integer> entryA : mapA.entrySet()) {
            for (Map.Entry<Character,Integer> entryB : mapB.entrySet()) {
                if(entryA.getKey() == entryB.getKey()){
                    cows += Math.min(entryA.getValue(),entryB.getValue());
                }
            }
        }
        sb.append(cows).append("B");
        return sb.toString();
    }

    public static void main(String[] args) {
        getHint("1807","7810");
    }
}
