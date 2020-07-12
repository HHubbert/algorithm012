/*
 * @lc app=leetcode.cn id=26 lang=csharp
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
public class Solution {
    public int RemoveDuplicates(int[] nums) {
        if(nums.Length <= 1) return nums.Length;

        int i = 0;
        for (int j = 1; j < nums.Length; j++) {
            if (nums[j] != nums[i]) {
                nums[++i] = nums[j];
            }
        }

        return ++i;
    }
}
// @lc code=end

