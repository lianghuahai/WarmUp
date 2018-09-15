package problem.day24;

public class Problem208 {
   /* public class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public String item = "";
    }
    
private TrieNode root = new TrieNode();
*//** Initialize your data structure here. *//*
public Trie() {
    
}

*//** Inserts a word into the trie. *//*
public void insert(String word) {
    TrieNode node = root;
    for(int i=0;i<word.length();i++){
        if(node.children[word.charAt(i)-'a']==null){
            node.children[word.charAt(i)-'a']= new TrieNode();
        }
        node=node.children[word.charAt(i)-'a'];
    }
    node.item=word;
}

*//** Returns if the word is in the trie. *//*
public boolean search(String word) {
    TrieNode node = root;
    for(int i=0;i<word.length();i++){
        if(node.children[word.charAt(i)-'a']==null){
            return false;
        }
        node=node.children[word.charAt(i)-'a'];
    }
    return node.item.equals(word);
}

*//** Returns if there is any word in the trie that starts with the given prefix. *//*
public boolean startsWith(String prefix) {
    TrieNode node = root;
    for(int i=0;i<prefix.length();i++){
        if(node.children[prefix.charAt(i)-'a']==null){
            return false;
        }
        node=node.children[prefix.charAt(i)-'a'];
    }
    return true;
}*/
}
