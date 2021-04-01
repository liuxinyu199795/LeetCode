/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode341  {
    //1.队列+dfs 先预处理，判断是不是数字，不是继续递归
    /*Deque<Integer> queue = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        dfs(nestedList);
    }

    @Override
    public Integer next() {
        return hasNext() ? queue.pollFirst() : -1;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    void dfs(List<NestedInteger> list) {
        for (NestedInteger item : list) {
            if (item.isInteger()) {
                queue.addLast(item.getInteger());
            } else {
                dfs(item.getList());
            }
        }
    }*/

    //2.栈+递归,逆序放入栈里，需要再处理
    /*Deque<NestedInteger> stack = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            NestedInteger item = list.get(i);
            stack.addLast(item);
        }
    }

    @Override
    public Integer next() {
        return hasNext() ? stack.pollLast().getInteger() : -1;
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()) {
            return false;
        } else {
            NestedInteger item = stack.peekLast();
            if (item.isInteger()) {
                return true;
            } else {
                item = stack.pollLast();
                List<NestedInteger> list = item.getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.addLast(list.get(i));
                }
                return hasNext();
            }
        }
    }*/

}
