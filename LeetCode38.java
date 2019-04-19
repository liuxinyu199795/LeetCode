public class LeetCode38 {
    public static String countAndSay(int n) {
        return count("1", 1, n);
    }

    public static String count(String current, int i, int j) {
        if (i == j) return current;
        if (i == 1) return count("11", ++i, j);

        char a = current.charAt(0);
        int num = 1;
        StringBuilder s = new StringBuilder();
        for (int k = 1; k < current.length(); k++) {
            if (a != current.charAt(k)) {
                // 找到不相同的字符
                s.append(num);
                s.append(a);
                num = 1;
                a = current.charAt(k);
                continue;
            }
            num ++;
        }

        s.append(num);
        s.append(a);
        return count(s.toString(), ++i, j);
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(10));
    }
}
