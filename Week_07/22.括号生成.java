import java.util.ArrayList;
import java.util.List;


/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();

        helper(res, 0, 0, n, "");

        return res;
    }

    private void helper(List<String> res, int left, int right, int n, String str) {
        if(str.length() == n * 2) {
            res.add(str);
            return;
        }

        if(left < n)
            helper(res, left + 1, right, n, str + "(");

        if(right < left)
            helper(res, left , right + 1, n, str + ")");
    }
}
// @lc code=end

