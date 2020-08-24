本周主要学习了Trie树，并查集，剪纸，双向BSF。还有AVL树和红黑树

Trie树
Trie树主要运用于统计和排序大量的字符串（但不仅限于字符串）
Trie树的核心思想就是空间换时间。
利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。
Trie树Java模板
```Java
class Trie {
    private boolean isEnd;
    private Trie[] next;
    /** Initialize your data structure here. */
    public Trie() {
        isEnd = false;
        next = new Trie[26];
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) return;
        Trie curr = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            int n = words[i] - 'a';
            if (curr.next[n] == null) curr.next[n] = new Trie();
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }


    private Trie searchPrefix(String word) {
        Trie node = this;
        char[] words = word.toCharArray();
        for (int i = 0;i < words.length;i++) {
            node = node.next[words[i] - 'a'];
            if (node == null) return null;
        }
        return node;
    }
}
```
并查集
1. 主要运用于组团，配对问题。
2. 也就是在一个场景中，需要很快地判断这两个个体是不是在一个集合当中
3. 判断两个群组之间是不是一个群组以及很快地合并群组

并查集Java模板
```Java
// Java
class UnionFind { 
	private int count = 0; 
	private int[] parent; 
	public UnionFind(int n) { 
		count = n; 
		parent = new int[n]; 
		for (int i = 0; i < n; i++) { 
			parent[i] = i;
		}
	} 
	public int find(int p) { 
		while (p != parent[p]) { 
			parent[p] = parent[parent[p]]; 
			p = parent[p]; 
		}
		return p; 
	}
	public void union(int p, int q) { 
		int rootP = find(p); 
		int rootQ = find(q); 
		if (rootP == rootQ) return; 
		parent[rootP] = rootQ; 
		count--;
	}
}
```

双向BSF模板
``` Java

public void two_endedBSF (String begin, String end) {
    Set<String> beginSet = new HashSet<String>();
    Set<String> endSet = new HashSet<String>();
    
    beginSet.add(begin);
    endSet.add(end);

    Set<String> visited = new HashSet<String>();
    
    while (!begin.isEmpty()) {
        //判断哪个长度比较小，优先进行遍历
        if (beginSet.size() > endSet.size()) {
            Set<String> temp = beginSet;
            beginSet = endSet;
            endSet = temp;
        }

        Set<String> nextSet = new HashSet<String>();
        for (String str : beginSet) {
            String target = process(str);//处理当前逻辑

            if (endSet.contains(target))
                return;
            
            if (!visited.contains(target)) {
                visited.add(target);
                nextSet.add(target);
            }
        }

        beginSet = nextSet;
    }
}

```