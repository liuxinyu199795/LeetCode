public class LeetCode208 {
    public class TrieNode{
        public char val;
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public TrieNode(){}
        TrieNode(char c){
            TrieNode node = new TrieNode();
            node.val = c;
        }
    }
    private TrieNode root;
    public LeetCode208() {
        root = new TrieNode();
        root.val=' ';
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode ws = root;
        for (int i = 0; i <word.length() ; i++) {
            char c = word.charAt(i);
            if(ws.children[c-'a']==null){
                ws.children[c-'a']= new TrieNode(c);
            }
            ws=ws.children[c-'a'];//往下走
        }
        ws.isWord=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode ws = root;
        for (int i = 0; i <word.length() ; i++) {
            char c = word.charAt(i);
            if(ws.children[c-'a']==null) return false;
            ws=ws.children[c-'a'];//往下走
        }
        return ws.isWord;//判断是否是单词的结尾，而不是一部分
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode ws = root;
        for (int i = 0; i <prefix.length() ; i++) {
            char c = prefix.charAt(i);
            if(ws.children[c-'a']==null) return false;
            ws=ws.children[c-'a'];//往下走
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
