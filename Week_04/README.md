本周主要学习了DFS，BFS，二分查找

#DFS（Depth First Search）深度优先搜索
迭代方式通过Stack进行实现，Java模板如下：
```Java
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

```C++
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

#BFS（Breath First Search）广度优先搜索
像声波一样扩散出去的搜索，非递归方式使用队列

```Java
    //非递归写法模板
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
#二分查找
##前提条件
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
2. 能够通过索引访问（index accessible）

```Java
    // Java二分查找模板
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

##针对旋转数组进行二分查找指定值的方法如下：
1. mid值如果大于0，说明[0,mid]这个区间是单调递增的，如果target > nums[mid] || target < nums[mid]，则说明target值是在mid的右边，low = mid + 1;
2. 否则就说明[0,mid]这个区间不是单调递增的，中间有分界点，但如果此时target > nums[mid] && target < nums[0]，说明了target的值也是在mid的右边，所以low = mid + 1;
3. 最后如果上面都不符合的话，target的值就在[0,mid]之间，所以此时high = mid - 1;

##针对二分查找还有相对于的变体 1-4代码针对单调递增的数组情况

###1.查找第一个值等于给定值的元素
```Java
public int bsearch(int[] a, int n, int value) {
    int low = 0;
    int high = n - 1;
    while (low <= high) {
        int mid =  low + ((high - low) >> 1);
        if (a[mid] > value) {
        high = mid - 1;
        } else if (a[mid] < value) {
        low = mid + 1;
        } else {
        if ((mid == 0) || (a[mid - 1] != value)) return mid;
        else high = mid - 1;
        }
    }
    return -1;
}
```

###2.查找第最后一个值等于给定值的元素
```Java
public int bsearch(int[] a, int n, int value) {
  int low = 0;
  int high = n - 1;
  while (low <= high) {
    int mid =  low + ((high - low) >> 1);
    if (a[mid] > value) {
      high = mid - 1;
    } else if (a[mid] < value) {
      low = mid + 1;
    } else {
      if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
      else low = mid + 1;
    }
  }
  return -1;
}
```

###3.查找第一个大于等于给定值的元素
```Java

public int bsearch(int[] a, int n, int value) {
  int low = 0;
  int high = n - 1;
  while (low <= high) {
    int mid =  low + ((high - low) >> 1);
    if (a[mid] >= value) {
      if ((mid == 0) || (a[mid - 1] < value)) return mid;
      else high = mid - 1;
    } else {
      low = mid + 1;
    }
  }
  return -1;
}
```

###4.查找最后一个小于等于给定值的元素

```Java

public int bsearch7(int[] a, int n, int value) {
  int low = 0;
  int high = n - 1;
  while (low <= high) {
    int mid =  low + ((high - low) >> 1);
    if (a[mid] > value) {
      high = mid - 1;
    } else {
      if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
      else low = mid + 1;
    }
  }
  return -1;
}
```

###5.寻找旋转排序数组中的最小值
```Java
public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if(nums.length == 1 || nums[low] < nums[high])
            return nums[low];

        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            else if(nums[mid] < nums[mid - 1])
                return nums[mid];

            if(nums[mid] > nums[0])
                low = mid + 1;
            else 
                high = mid - 1;
        }

        return -1;
    }
```