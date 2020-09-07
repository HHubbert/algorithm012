/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

// @lc code=start
class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        dp[1] = 1; 
        for(int i = 2; i < s.length(); i++) {
            if(s.charAt(i) == '0')
                if(s.charAt(i-1) == '1' || s.charAt(i-1) == '2') dp[i] = dp[i-1];
                else return 0;
            else if(s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'))
                dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[s.length()];
    }
}
// @lc code=end

