import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {

    List<List<Integer>> output = new LinkedList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;

        _backtrack(1, new LinkedList<>());

        return output;
    }

    private void _backtrack(int first, LinkedList<Integer> curr) {
        if(curr.size() == k)
            output.add(new LinkedList<Integer>(curr));

        for(int i = first; i < n + 1; i++) {
            curr.add(i);

            _backtrack(i + 1, curr);

            curr.removeLast();
        }
    }
}
// @lc code=end

