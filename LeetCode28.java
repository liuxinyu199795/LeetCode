


public class LeetCode28 {
    public static int strStr(String haystack, String needle) {
        if(haystack.length()==0) return 0;
        if(haystack.length()<=needle.length()) return -1;
        int i=0;
        for (int j = 0; j <haystack.length() ; j++) {
            if(haystack.charAt(j)==needle.charAt(i)){
                int k=j+1;
                int l;
                //开始同时遍历
                for (l=1; l <needle.length() ; l++) {
                   if(haystack.charAt(k)==needle.charAt(l)){
                       k++;
                   }else return -1;
                }
                if(l==needle.length()){
                    return j;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str ="hello";
        String str1="ll";
        System.out.println(strStr(str,str1));
    }
}
