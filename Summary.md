期末总结
# 数组 Array
- 在内存中开辟了一段连续的存储地址，知道了数组的下标，可以以O(1)的时间复杂度读取元素。但在插入元素的时候，时间复杂度为O(n)
``` Java
//Java ArrayList add方法
 public void add(int index, E e)
 {
     checkBoundInclusive(index);
     modCount++;
     if (size == data.length)
        ensureCapacity(size + 1);
     if (index != size)
        System.arraycopy(data, index, data, index + 1, size - index);
     data[index] = e;
     size++;
}
```

# 链表 LinkedList
- 链表弥补了数组的缺点，在修改和添加操作的时候，时间复杂度是O（1）
    - 尤其是在添加删除比较频繁的情况下，数组并不好用
    - 链表的数据结构就是本身有个Value值和Next下一个指针指向下一个元素，串在一起就形成了一个类似数组的一个结构
    - 一般元素都是用class来进行定义（Node），一个Value值，还有一个Next指针
    - 如果只有一个指针，就叫做单链表
    - 如果需要指向前一个指针的话，就会有一个prev的指针，这种就叫做双向链表，既能往前走，也能往后走
    - 一般链表头指针用head表示，尾指针用tail进行表示。tail一般指向空节点
    - 如果tail指向了head节点，那么此时就是一个循环链表

# 跳表 Skip List
-  跳表特点
    - 元素始终是有序的
    - 跳表对标的是AVL Tree和 二分查找 都是O(log n)的数据结构
    - 原理简单，容易实现，方便扩展，效率更高
    - 升维思想 + 空间换时间

# 栈 Stack（First in last out）
- 先进后出

# 队列 Queue（First in First out）
- 先进先出
- Stack 和 Queue的关键点
    - Stack先入后出，添加删除都为O（1）
    - Queue先入先出，添加删除都为O（1）

# 双端队列Deque（Double-End Queue）
- Deque
    - 双端可以进出的Queue Deque-double ended queue
    - 插入和删除都是O（1）

# 优先级队列（Priority Queue）
- 插入是O（1）
- 取值操作：O（logN）-按照元素的优先级取出
- 底层实现的数据结构较为多样和复杂：heap，bst，treap        

# 哈希表（Hash Table）
- 也叫散列表，是根据关键码值(Key value)而直接进行访问的数据结构。
- 工程实践
    - 电话号码簿
    - 用户信息表
    - 缓存（LRU Cache）
    - 键值对存储（Redis）
- 哈希碰撞
    - 如果不同的字符最后通过哈希函数算出来的值一样的，就是哈希碰撞。
    - 拉链式解决冲突法
        - 一个数据通过哈希函数得到它的下标的值，这整个操作都是O（1）的。也就是O（1）可以找到它的下标，它的位置。但是如果很多个元素都积累在同一个位置的话，这时候查找某一个元素就需要遍历链表了，所以如果链表很长，效率就会倒退，退化到O（n）。如果哈希函数设计的比较好。哈希函数的膨胀概率会很小，所以在平均时刻的查询，可以认为是O（1）的时间复杂度的。
        - 最坏的情况是hash函数没选好，就导致经常性的有哈希碰撞。一冲突就变成了链表。但是现在计算机的内存很大，所以哈希表也可以很大，所以默认可以认为HashTable的增加删除的时间复杂度时O(1)。
- 在工程上，就不经常使用哈希表了，而是使用Map和Set
    - set是一个接口，它的实现有HashSet。TreeSet，treeset是用二叉搜索树，就是使用红黑树来实现的。

# 树 Tree
- 有根节点
- 有左儿子和右儿子
- 相对于儿子节点来说，就会有父亲节点。

# 二叉树 Binary Tree
- 基本定义：儿子只有两个
- 树跟图最大的差别：看有没有环。
    - 链表是特殊化的树。因为树有两个next指针
    - 树是特殊化的图。没有环的图就是树

- 树的遍历：前序，中序，后序
- 树为什么适合用递归？
    - 因为树本身的数据结构没有办法有效的进行循环。也没有所谓的后继。而更多的是左节点右节点。所以要访问左树的话，直接再调用相同的遍历函数。即可。写递归调用会相对比较容易。

# 二叉搜索树 Binary Search Tree
- 因为对于普通的树，如果要查找某一个节点。我们必须遍历整个树。要遍历的话就是O（n）的算法复杂度。
- 二叉搜索树的定义：
    - 左子树上所有节点的值均小于它的根节点的值
    - 右子树上所有节点的值均大于它的根节点的值
    - 并且节点的左右子树也符合该情况。（这就是重复性！）

- 二叉树常见操作
    - 查询O（logN）
    - 插入O（logN）
    - 这样就比链表的查询O（n）快了很多二叉树的搜索每次可以判断是向左子树走还是向右子树走。每次可以筛选掉一半的元素。插入，就是一直找，找到叶子节点，再往它的左右子树进行插入即可。

    - 删除，分两种情况
        - 删除叶子节点，直接删除即可。
        - 删除有左右节点的节点。
        - 左子树的最右叶子节点，也就是最大的节点
        - 右子树的最左的叶子节点，也就是最小的节点，替换掉删除节点即可。（一般采用这种方法）
- 一个空树就是二叉搜索树
    - 二叉搜索树使用中序遍历可以得到一个升序数组。
    - 二叉搜索树的最坏情况，退化成链表

# 堆 Heap
- 定义: 
    - 可以迅速找到一堆数中的最大或者最小值的数据结构。
    - 大顶堆：
        - find-max：O（1）
        - delete-max：O（logN）
        - insert：O（logN） 斐波那契堆是O（1）

- 假设维护一个数组来实现二叉堆。每次新增一个元素，就需要把数组进行排序。时间复杂度为O（nlogn）。这样就不够高效。另外删除的话，如果最大最小的值在数组最后还好，直接删除即可。如果在最前面进行删除，还需要把后面的元素往前移动。那这样时间复杂度又变差了。所以如果只是简单的进行排序进行实现，那么就会很低效。那么就需要升维，变成一种二维的数据结构。

- 二叉堆的性质
    - 通过完全二叉树来实现
    - 二叉堆（大顶堆）满足下列性质：
        - 是一棵完全树
        - 树种任意节点的值总是 >= 子节点的值
    - 索引为i的左儿子的下标为（2*i+1）;
    - 下标为i的右儿子的下标为（2*i+2）;
    - 索引为i的父结点的索引是floor（（i-1）/2）

- 插入操作HeapifyUp：
    - 把新元素插入到堆的尾部
    - 依次向上调整整个堆的结构（一直到根即可）
    -  时间复杂度，在最坏的情况下，就是树的深度，因为有n个节点，所以最坏的时间复杂度为O（log2n）。
- 删除操作HeapifyDown:
    - 将堆尾元素替换到顶部（即对顶被替代删除掉）
    - 一次从跟不向下调整整个堆的结构（一直到堆尾即可）
    - 关键点是尾部元素替换根节点，然后比较左右儿子谁最大进行交换，因为要符合根节点（父亲节点）的值最大。

- 堆的性质总结: 堆是一个抽象的数据结构，表示可以最快的拿到一位数组中最大或者最小的值。它并不是二叉堆。
- 在工程直接使用priority_queueu优先级队列即可。

# 图
- 定义：有点有边
    - 度
        - 分为入度和出度。表示一个点，有多少条边。
        - 如果一个图是无向的，那么它的入度就等于出度。
        - 当边是有向的，一个点一个交通纽带，就有多少条边可以进来和有多少条边可以出去。
        - 这个路的个数就是指它的入度和出度。
        - 点和点之间是否有联通， 连通的话表示直接有边相连。

    - 边
        - 是否有向和无向
        - 有些时候两个点只能单向，有的时候能双向。
        - 权重：边的长度。也可以理解为损耗，也就是走这条边的费用是多少。
    
    - 一种是链接矩阵，一种是链接表。都是两个维度。
    - 链接矩阵，横坐标和纵坐标表示是否相连。0为不相连。1或者其他数字表示相连或者之间的距离是多少。
    - 链接表，第一列表示是的点的坐标，0后面链接的是1和3.看上面的图。如果0没连任何点的话，这个0就是独立的存在。
    - 因为边是没有反向的，所以链接矩阵是对称的。
    - 如果点跟点之间没有权重，也没有方向，那么就是无向无权图。
- 图的相关算法：BFS 和 DFS


# 递归的实现、特性以及思维要点
- 定义： 通过函数体循环调用自己进行循环
``` Java
// Java 递归模板
public void recur(int level, int param) { 
  // terminator 
  if (level > MAX_LEVEL) { 
    // process result 
    return; 
  }
  // process current logic 
  process(level, param); 
  // drill down 
  recur( level: level + 1, newParam); 
  // restore current status 
 
}
```
- 思维要点
  - 不要人肉递归，（最大误区）直接看函数本身开始写即可
  - 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）因为写的程序只包括if else for while loop 递归调用
  - 数学归纳法思维
    - 最开始n = 1， n = 2是成立的
    - 能够证明当n成立的时候，可以推到n+1也成立


# 分治 回溯
-  分治和回溯是一种较为复杂的递归
    - 重复性有：最近重复性（怎么分解=>分治，回溯）和最优重复性（动态规划）

- 分治
    - 化解为几个子问题= > 一个大问题都是由很多几个子问题组合
    - 所有算法最后的本质上都是找重复性以及分解问题和最后组合每个子问题的结果

分治代码模块
```C++
C/C++
int divide_conquer(Problem *problem, int params) {
  // recursion terminator
  if (problem == nullptr) {
    process_result
    return return_result;
  } 


  // process current problem
  subproblems = split_problem(problem, data)
  subresult1 = divide_conquer(subproblem[0], p1)
  subresult2 = divide_conquer(subproblem[1], p1)
  subresult3 = divide_conquer(subproblem[2], p1)
  ...


  // merge
  result = process_result(subresult1, subresult2, subresult3)
  // revert the current level status
 
  return 0;
}
```
1. 分治跟递归有点不同的是需要将结果进行组合然后返回
2. 第一步teminator，递归的层级到达了最下一层，也就是到了它的叶子节点，叶子节点对于分治来说的话，叶子节点到达的标志在于子问题没有了，就没有问题需要解决了
3. 第二步process current process,处理当前层逻辑，就是把大问题转换成解决子问题
4. 第三步drill down,调用这个函数下探到下一层

- 回溯
    -  回溯需要递归找出所有的结果，接着对结果进行筛选，难点是递归的参数。
    -  回溯法是一种探索所有潜在可能性找到解决方案的算法。如果当前方案不是正确的解决方案，或者不是最后一个正确的解决方案，则回溯法通过修改上一步的值继续寻找解决方案。


# DFS 
``` Java
//Java递归写法
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }

    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }
```

``` C++
//C/C++
//非递归写法：
void dfs(Node* root) {
  map<int, int> visited;
  if(!root) return ;

  stack<Node*> stackNode;
  stackNode.push(root);

  while (!stackNode.empty()) {
    Node* node = stackNode.top();
    stackNode.pop();
    if (visited.count(node->val)) continue;
    visited[node->val] = 1;

    for (int i = node->children.size() - 1; i >= 0; --i) {
        stackNode.push(node->children[i]);
    }
  }


  return ;
}
```
# BFS

``` Java
//Java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;


    TreeNode(int x) {
        val = x;
    }
}


public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```


# 二分查找
- 二分查找模板
``` Java
// Java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }


    return -1;
}
```
- 二分查找的前提
    - 目标函数单调性（单调递增或者递减）
    - 存在上下界（bounded）
    - 能够通过索引访问（index accessible）

# 动态规划
- DP
    - 重复性（分治）
        - problem（i, j） = min（sub(i+1, j) , sub(i+1,j+1)） + a[i,j]
    - 定义状态数组
        - f[i，j] 表示从上走到下面的最小路径是多少
    - DP方程
        - f（i, j） = min（f(i+1, j) , f(i+1,j+1)） + a[i,j]
    - 即使是DP，根据你状态定义的数组定义的不一样，方向不一样，也会有不同的写法。且不同写法的整洁程度不一样

# 字典树
- 字典树，即Trie树，又称单词查找树或键树，是一种树形结构。
- 典型应用施用于统计和排序大量的字符串（但不仅限于字符串）
- 所以经常被搜索引擎系统用于文本词频统计
- 优点：最大限度地减少无谓的字符串比较，查询效率比哈希表高
- Trie树的核心思想就是空间换时间。
- 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

- 性质
    - 节点本身不存在完整单词
    - 从根节点到某一结点，路径上经过的字符连接起来，为该结点对应的字符串
    - 每个结点的所有子结点代表的字符都不相同

```Java
//Java
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

# 并查集 Disjoint Set
- 适用场景
    - 组团，配对问题
    - 也就是在一个场景中，需要很快地判断这两个个体是不是在一个集合当中
    - 判断两个群组之间是不是一个群组以及很快地合并群组
    - LeetCode : 朋友圈，孤岛

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

# 位运算
- 位运算符
    - 左移就是，将整串的二进制符号往左移一位，同时空出来的二进制补零
    - 右移，同理跟左移一样的道理
    - 或运算，只要有一位为1，则为1。 => 类比程序语言的或，只要有一个为true，则全为true
    - 与运算，只要有一位为0，则为0。
    - 按位取反，每个位数取反
    - 按位异或（相同为0，不同为1） => 异或，只有不相同为1，相同的就不是异了，为0.

- 常见的一些运算操作
    - 判断奇偶性 ：
        - x % 2 == 0 => (x&1) == 1
        - x % 2 == 1 => (x&1) == 0
    - x >> 1 => x / 2
    - x = x &(x - 1) 清零最低位1
    - x & -x => 得到最低位1
    - x & -x => 0

# LRU
- 两个要素：大小、替换策略
- HashTable + Double Linkedlist
- O(1)查询
- O(1)修改、更新
- Least Rectent Use 最近最少使用，就放在最后淘汰

```Java
public class LRUCache {
    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }


    private Map<Integer, DLinkedNode> cache = new HashMap<Integer, DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;


    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }


    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }


    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }


    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }


    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }


    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }


    private DLinkedNode removeTail() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
```

# 布隆过滤
- 如果某个元素不存在布隆过滤器，则一定不存在， 如果存在，不一定存在。需要进一步通过其他方式确认