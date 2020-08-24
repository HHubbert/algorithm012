/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    private boolean isEnd;
    private Trie[] next;

    /** Initialize your data structure here. */
    public Trie() {
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0) return;

        Trie curr = this;
        char[] words = word.toCharArray();
        for(int i = 0; i < words.length; i++) {
            int n = words[i] - 'a';
            curr.next[n] = new Trie();
            curr = curr.next[n];
        }

        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie curr = searchPrefix(word);
        return curr != null && curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie curr = searchPrefix(prefix);
        return curr != null;
    }

    private Trie searchPrefix(String prefix) {
        Trie curr = this;
        char[] words = prefix.toCharArray();
        for(int i = 0; i < words.length; i++) {
            int n = words[i] - 'a';
            if(curr.next[n] != null)
                curr = curr.next[n];
            else
                return null;
        }
        return curr;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

