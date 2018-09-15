package problem.day24;

public class Problem211 {
    //a root has its 26 a-z alphabets children TrieNode[] children = new TrieNode[26], and items presents a word
    //every time we insert a word, we start at root for each character(dfs to the end of the word)
    public class WordDictionary {
        public class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public String item = "";
            
        }
        
        private TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.item = word;
        }

        public boolean search(String word) {
            return match(word.toCharArray(), 0, root);
        }
        //recursive
        private boolean match(char[] chs, int k, TrieNode node) {
            if (k == chs.length) return !node.item.equals("");    ///base case,found word or not
            if (chs[k] != '.') { 
                return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
            } else {
                for (int i = 0; i < node.children.length; i++) {
                    if (node.children[i] != null) {
                        if (match(chs, k + 1, node.children[i])) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }
}
