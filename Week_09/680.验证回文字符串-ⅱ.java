/*
 * @lc app=leetcode.cn id=680 lang=java
 *
 * [680] 验证回文字符串 Ⅱ
 */

// @lc code=start
class Solution {
    public boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        
        return recurr(s, low, high, 1);
    }

    private boolean recurr(String s, int low, int high, int count) {
        while (low < high) {
            char c1 = s.charAt(low), c2 = s.charAt(high);
            if (c1 != c2) {
                if(count == 0) return false;
                return recurr(s, low + 1, high, count - 1) 
                        || recurr(s, low, high - 1, count - 1);
            }
            low++;
            high--;
        }
        return true;
    }
}
// @lc code=end

