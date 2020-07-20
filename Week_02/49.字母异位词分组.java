import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList<List<String>>();

        int[] count = new int[26];
        Map<String, List<String>> ans = new HashMap<String, List<String>>();
        
        for (String str : strs) {
            Arrays.fill(count, 0);
            char[]ch = str.toCharArray();

            for (char c : ch) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i : count) {
                sb.append("#");
                sb.append(i);
            }

            String key = sb.toString();
            if(!ans.containsKey(key)) ans.put(key, new ArrayList<String>());
            ans.get(key).add(str);
        }

        return new ArrayList<List<String>>(ans.values());
    }
}
// @lc code=end

