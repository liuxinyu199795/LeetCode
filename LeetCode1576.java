public class LeetCode1576 {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length ; i++) {
            if(chars[i] == '?'){
                char a = 'a';
                while((i > 0 && chars[i - 1] == a) || (i < length - 1 && chars[i + 1] == a)) a++;
                chars[i] = a;
            }
        }
        return new String(chars);
    }
}
