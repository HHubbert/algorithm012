import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s,t) && isIsomorphicHelper(t,s);
    }
    
    public boolean isIsomorphicHelper(String s, String t) {
        Map<Character,Character> map = new HashMap<>();
        int index = 0;
        while (index < s.length()) {
            char sChar = s.charAt(index);
            char tChar = t.charAt(index);
            if(map.containsKey(sChar) && map.get(sChar) != tChar)
                return false;
            else
                map.put(sChar, tChar);

            index++;
        }

        return true;
    }
}
// @lc code=end

