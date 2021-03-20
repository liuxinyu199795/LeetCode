

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @ProjectName: LeetCode
 * @Author: XinyuLiu
 * @Description:
 */
public class LeetCode150 {
    //1.数组模拟栈
    /*public int evalRPN(String[] ts) {
        int[] d = new int[ts.length];
        int hh = 0, tt = -1;
        for (String s : ts) {
            if ("+/-*".contains(s)) {
                int b = d[tt--], a = d[tt--];
                d[++tt] = calc(a, b, s);
            } else {
                d[++tt] = Integer.parseInt(s);
            }
        }
        return d[tt];
    }
    int calc(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        else if (op.equals("-")) return a - b;
        else if (op.equals("*")) return a * b;
        else if (op.equals("/")) return a / b;
        else return -1;
    }*/
    //2.自带栈解法
    public int evalRPN(String[] ts) {
        Deque<Integer> d = new ArrayDeque<>();
        for (String s : ts) {
            if ("+-*/".contains(s)) {
                int b = d.pollLast(), a = d.pollLast();
                d.addLast(calc(a, b, s));
            }  else {
                d.addLast(Integer.parseInt(s));
            }
        }
        return d.pollLast();
    }
    int calc(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        else if (op.equals("-")) return a - b;
        else if (op.equals("*")) return a * b;
        else if (op.equals("/")) return a / b;
        else return -1;
    }
}
