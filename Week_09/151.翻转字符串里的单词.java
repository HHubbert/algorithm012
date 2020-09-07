import java.util.Arrays;
import java.util.Collections;

/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 翻转字符串里的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        String[] tmp = s.trim().split(" +");
        Collections.reverse(Arrays.asList(tmp));
        return String.join(" ", tmp);
    }
}
// @lc code=end

