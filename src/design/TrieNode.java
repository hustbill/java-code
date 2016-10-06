/*
208. Implement Trie (Prefix Tree) 
Total Accepted: 49308
Total Submissions: 192557
Difficulty: Medium
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.

Hide Company Tags Google Uber Facebook Twitter Microsoft Bloomberg
Hide Tags Design Trie
Hide Similar Problems (M) Add and Search Word - Data structure design

*/


class TrieNode {
	public char val;
	public boolean isWord;
	public TrieNode[] children = new TrieNode[26];
	
    // Initialize your data structure here.
    public TrieNode() {
    	TrieNode node = new TrieNode();
		node.val = c;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
		root.val = ' ';
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");