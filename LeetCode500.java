import java.util.ArrayList;
import java.util.List;

public class LeetCode500 {
    static int[] nums = new int[26];
    static {
        set("qwertyuiop",1);
        set("asdfghjkl",2);
        set("zxcvbnm",3);
    }
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if(check(word)){
                list.add(word);
            }
        }
        return list.toArray(new String[list.size()]);
    }
    static void set(String str,int value){
        for (char c : str.toCharArray()) {
            nums[index(c)] = value;
        }
    }
    static int index(char c){
        if(c >= 'A' && c <= 'Z'){
            return c - 'A';
        }else{
            return c - 'a';
        }
    }
    boolean check(String str){
        int value = 0;
        for (char c : str.toCharArray()) {
            if(value == 0){
                value = nums[index(c)];
            }
            if(value != nums[index(c)]){
                return false;
            }
        }
        return true;
    }
}
