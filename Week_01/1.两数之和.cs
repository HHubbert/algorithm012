/*
 * @lc app=leetcode.cn id=1 lang=csharp
 *
 * [1] 两数之和
 */

// @lc code=start
public class Solution {
    public int[] TwoSum(int[] nums, int target) {

        Dictionary<int, int> dic = new Dictionary<int, int>();

        for (int i = 0; i < nums.Length; i++) {
            
            int anotherNum = target - nums[i];

            if (dic.ContainsKey(anotherNum)) {
                return new int[]{dic[anotherNum], i };
            }
            
            if (!dic.ContainsKey(nums[i])) {
                dic.Add(nums[i], i);
            }

        }

        throw new Exception("No two sum solution");
    }
}
// @lc code=end

