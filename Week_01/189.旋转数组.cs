/*
 * @lc app=leetcode.cn id=189 lang=csharp
 *
 * [189] 旋转数组
 */

// @lc code=start
public class Solution {

    //1. 暴力解法
    // public void Rotate(int[] nums, int k) {
    //     for (int i = 0; i < k ; i++) {
    //         int previous = nums[nums.Length - 1];
    //         for (int j = 0; j < nums.Length ; j++) {
    //             int temp = nums[j];
    //             nums[j] = previous;
    //             previous = temp;
    //         }
    //     }
    // }

    //2. 使用额外的数组
    //通过使用[(下标i+k)%数组长度]移动原有的数组下标
    //O(n)时间复杂度 O(n)空间复杂度
    // public void Rotate(int[] nums, int k) {
    //     int [] temp = new int[nums.Length];
    //     for (int i = 0; i < nums.Length; i++) {
    //         temp[(i+k)%nums.Length] = nums[i];
    //     }

    //     for (int i = 0; i < nums.Length; i++) {
    //         nums[i] = temp[i];
    //     }
    // }

    //4.使用反转
    public void Rotate(int[] nums, int k) {
        k %= nums.Length;

        _reverse(nums, 0, nums.Length - 1);
        _reverse(nums, 0, k-1);
        _reverse(nums, k, nums.Length - 1);
    }

    private void _reverse(int [] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}
// @lc code=end

