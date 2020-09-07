/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int i = 0;
        while(i < n) {
            int start = i;
            while (i < n && s.charAt(i) != ' ') 
                i++;

            for(int j = start; j < i; ++j) 
                sb.append(s.charAt(start + i - 1 - j));
            
            while(i < n && s.charAt(i) == ' ') {
                i++;
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
// @lc code=end

