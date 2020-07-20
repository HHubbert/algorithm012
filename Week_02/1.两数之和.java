import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            int sub = target - nums[i];

            if(map.containsKey(sub)) {
                return new int []{map.get(sub), i};
            }
            map.put(nums[i] , i);
        }

        return new int[]{};
    }
}
// @lc code=end

