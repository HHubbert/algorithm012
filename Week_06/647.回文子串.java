/*
 * @lc app=leetcode.cn id=647 lang=java
 *
 * [647] 回文子串
 */

// @lc code=start
class Solution {
    //1. 分解为子问题 problem(i,j) = sub(i + 1, j - 1)... i, j 表示从下标i到下标j的字符串
    //2. 定义状态数组 定义一个二维数组，长度为字符串的长度，i，j表示从i到j是否为回文，如果是则为true，不是则为false
    //3. dp方程 当s[i] == s[j] => dp[i][j] = dp[i+1][j-1] || i = j - 1 dp[i][j] = true;
    public int countSubstrings(String s) {
        int count = 0;

        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }

        //从右下角开始遍历
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n ; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(i == j - 1)
                        dp[i][j] = true;
                    else
                        dp[i][j] = dp[i+1][j-1];
                } else {
                    dp[i][j] = false;
                }

                if(dp[i][j]) count++;
            }
        }

        return count;
    }
}
// @lc code=end

