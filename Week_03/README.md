1. 本周主要学习了递归，以及回溯和分治法，但这两种方法本质上都是递归。
2. 树的面试题解法一般都是【递归】
3. // Java 递归模板
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

4. 递归的思维要点：
    1. 可以不需要人肉递归
    2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
    3. 数学归纳法思维
        1. 最开始n = 1， n = 2是成立的
        2. 能够证明当n成立的时候，可以推到n+1也成立
        3. 类似放鞭炮，第一个点燃，接下来的炮竹全部爆炸。
    4. 递归题目练习：
        1. 爬楼梯：https://leetcode-cn.com/problems/climbing-stairs/
        2. 括号生成问题 ： https://leetcode-cn.com/problems/generate-parentheses/

5. 分治和回溯是一种较为复杂的递归
6. 重复性有：最近重复性（怎么分解=>分治，回溯）和最优重复性（动态规划）
7. 分治代码模板
8. C/C++
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
9. 分治跟递归有点不同的是需要将结果进行组合然后返回
分治练习题目：
从前序与中序遍历序列构造二叉树 ： https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
10. 回溯是一种探索所有潜在可能性找到解决方案的算法。如果当前方案不是正确的解决方案，或者不是最后一个正确的解决方案，则回溯法通过修改上一步的值继续寻找解决方案。
11. 总的来说，回溯需要递归找出所有的结果，接着对结果进行筛选，难点是递归的参数。
回溯练习题目：
全排列： https://leetcode-cn.com/problems/permutations/
