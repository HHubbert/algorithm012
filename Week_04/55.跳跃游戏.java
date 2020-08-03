/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reach = 0;

        for (int i = 0; i <= reach && reach < n - 1 ; i++) {
            reach = Math.max(reach, i + nums[i]);
        }

        return reach >= n - 1;
    }
}
// @lc code=end

