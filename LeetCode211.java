public class LeetCode211 {
    class Node{
        Node[] tns = new Node[26];
        boolean isWord;
    }
    Node root = null;
    public LeetCode211() {
        root = new Node();
    }

    public void addWord(String word) {
        Node p = new Node();
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if(p.tns[u] == null) p.tns[u] = new Node();
            p = p.tns[u];
        }
        p.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word,root,0);
    }
    boolean dfs(String s,Node p,int sIdx){
        int n = s.length();
        if(sIdx == n) return p.isWord;
        char c = s.charAt(sIdx);
        if(c == '.'){
            for (int i = 0; i < 26; i++) {
                if(p.tns[i] != null && dfs(s,p.tns[i], sIdx + 1)) return true;
            }
            return false;
        }else{
            int u = c - 'a';
            if(p.tns[u] == null) return false;
            return dfs(s,p.tns[u], sIdx + 1);
        }
    }
}
