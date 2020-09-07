/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] res = S.toCharArray();
        int start = 0, end = S.length() - 1;
        while (start < end) {
            while(start < end && !Character.isLetter(S.charAt(start)))
                start++;

            while(start < end && !Character.isLetter(S.charAt(end)))
                end--;
            
            char tmp = res[start];
            res[start] = res[end];
            res[end] = tmp;

            start++;
            end--;
        }

        return String.valueOf(res);
    }
}
// @lc code=end

