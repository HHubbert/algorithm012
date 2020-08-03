/*
 * @lc app=leetcode.cn id=33 lang=java
 *
 * [33] 搜索旋转排序数组
 */

// @lc code=start
class Solution {
    public int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        while(low < high) {
            int mid = (high - low) / 2 + low;

            if(nums[0] <= nums[mid] && (target > nums[mid] || target < nums[0]))
                low = mid + 1;
            else if(target < nums[0] && target > nums[mid])
                low = mid + 1;
            else 
                high = mid;
        }

        return low == high && nums[low] == target ? low : -1;
    }
}
// @lc code=end

