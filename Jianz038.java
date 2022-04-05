import java.util.*;

public class Jianz038 {
    //1.递归
    Set<String> res = new HashSet<>();
    int length;
    char[] array;
    public ArrayList<String> Permutation(String str) {
        if(str.length() == 0) return new ArrayList<>();
        length = str.length();
        array = str.toCharArray();
        perm(0);
        ArrayList<String> r = new ArrayList<>(res);
        Collections.sort(r);
        return r;
    }
    public void perm(int k){
        if(k == length){
            String s = new String(array);
            if(!res.contains(s)) res.add(s);
            return;
        }
        int i = k;
        for (; i < length; i++) {
            swap(k,i);
            perm(k + 1);
            swap(k,i);
        }
    }
    public void swap(int i,int j){
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
