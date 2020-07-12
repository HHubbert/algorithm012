/*
 * @lc app=leetcode.cn id=283 lang=csharp
 *
 * [283] 移动零
 */

// @lc code=start
public class Solution {
    public void MoveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.Length; j++) {
            if(nums[j] != 0) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
// @lc code=end

