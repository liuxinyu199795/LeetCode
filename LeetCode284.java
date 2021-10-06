import java.util.Iterator;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode284 {
    Iterator<Integer> iter;
    Integer next;
    public LeetCode284(Iterator<Integer> iterator) {
        iter = iterator;
        if (iter.hasNext()) next = iter.next();
    }

    public Integer peek() {
        return next;
    }

    public Integer next() {
        Integer ans = next;
        next = iter.hasNext() ? iter.next() : null;
        return ans;
    }

    public boolean hasNext() {
        return next != null;
    }
}
