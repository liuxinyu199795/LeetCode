import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode331 {
    //1.取巧-连连看法
    /*public boolean isValidSerialization(String preorder) {
        List<String> stack = new ArrayList<>();
        String[] split = preorder.split(",");
        for (int i = 0; i <split.length ; i++) {
            stack.add(split[i]);
            while (stack.size() >= 3
                    && stack.get(stack.size() - 1).equals("#")
                    && stack.get(stack.size() - 2).equals("#")
                    && !stack.get(stack.size() - 3).equals("#")) {
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.remove(stack.size() - 1);
                stack.add("#");
            }
        }
        return stack.size()==1 && stack.get(0).equals("#");
    }*/
    //2.出入度法
    public boolean isValidSerialization(String preorder) {
        String[] split = preorder.split(",");
        int diff = 1;
        for (String str:split) {
            diff -= 1;
            if(diff<0){//出不敷付
                return false;
            }
            if(!str.equals("#")){
                diff += 2;
            }
        }
        return diff==0;
    }
}
