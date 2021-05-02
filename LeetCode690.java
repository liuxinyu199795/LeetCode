import java.util.*;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode690 {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }
    //1.递归法(DFS深度优先，遍历完一条路才继续下一条)
    /*int sum = 0;
    Map<Integer,Employee> employeesMap = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            employeesMap.put(employee.id,employee);
        }
        getSumVal(id);
        return sum;
    }
    public void getSumVal(int id){
        Employee e = employeesMap.get(id);
        sum += e.importance;
        for (Integer i : e.subordinates) {
            getSumVal(i);
        }
        return;
    }*/
    //2.迭代（BFS队列，每层加入队列末尾）
    Deque<Employee> deque = new ArrayDeque<>();
    Map<Integer,Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        for (Employee e : employees) {
            map.put(e.id,e);
        }
        deque.addLast(map.get(id));
        while(!deque.isEmpty()){//队列判空要注意
            Employee employee = deque.pollFirst();
            sum += employee.importance;
            for (int i : employee.subordinates) {
                deque.addLast(map.get(i));
            }
        }
        return sum;
    }
}
