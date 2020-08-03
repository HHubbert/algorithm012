/*
 * @lc app=leetcode.cn id=153 lang=java
 *
 * [153] 寻找旋转排序数组中的最小值
 */

// @lc code=start
class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        if(nums.length == 1 || nums[low] < nums[high])
            return nums[low];

        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(nums[mid] > nums[mid + 1])
                return nums[mid + 1];
            if(nums[mid] > nums[0])
                low = mid + 1;
            else 
                high = mid - 1;
        }

        return -1;
    }
}
// @lc code=end

