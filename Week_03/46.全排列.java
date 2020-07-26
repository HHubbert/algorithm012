import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> output = new ArrayList<>();
        
        if(len == 0) return output;
        
        boolean[] used = new boolean[len];
        Deque<Integer> stack = new ArrayDeque<>();

        dfs(nums, len, used, stack, output);

        return output;
    }

    private void dfs(int[] nums, int len, boolean[] used, Deque<Integer> stack, List<List<Integer>> output) {
        if(stack.size() == len) {
            output.add(new ArrayList<>(stack));
            return;
        }

        for(int i = 0; i < len; i++) {
            if(used[i])
                continue;
            stack.add(nums[i]);
            used[i] = true;
            dfs(nums, len, used, stack, output);
            stack.removeLast();
            used[i] = false;
        }
    }
}
// @lc code=end

