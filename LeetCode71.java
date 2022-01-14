import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode71 {
    public String simplifyPath(String path) {
        int n = path.length();
        Deque<String> deque = new ArrayDeque<>();
        for (int i = 1; i < n;) {
            if(path.charAt(i) == '/' && ++i >= 0) continue;
            int j = i + 1;
            while(j < n && path.charAt(j) != '/') j++;
            String str = path.substring(i,j);
            if(str.equals("..")){
                if(!deque.isEmpty()) deque.pollLast();
            }else if(!str.equals(".")){
                deque.addLast(str);
            }
            i = j;
        }
        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append("/");
            sb.append(deque.pollFirst());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
