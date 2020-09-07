/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        char[] array = s.toCharArray();
        for(int start = 0; start < array.length - 1; start += 2 * k) {
            int q = start; 
            int p = Math.min(start + k - 1, s.length() - 1);
            while(q < p) {
                char tmp = array[q];
                array[q++] = array[p];
                array[p--] = tmp;
            }
        }

        return new String(array);
    }
}
// @lc code=end

