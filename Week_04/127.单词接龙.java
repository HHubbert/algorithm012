import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        //如果结果集没有endword直接返回0
        if(!wordSet.contains(endWord))
            return 0;
        
        wordSet.remove(beginWord);

        //定义一个队列
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        //标记已经访问过的节点
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);

        int step = 1;
        int wordLen = beginWord.length();

        while (!queue.isEmpty()) {
            int currLenght = queue.size();
            
            for (int i = 0; i < currLenght; i++) {

                String currWord = queue.poll();

                char[] currWordChar = currWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char originWord = currWordChar[j];

                    for (char k = 'a'; k <= 'z'; k++) {
                        if(k == originWord)
                            continue;

                        currWordChar[j] = k;
                        String temp = String.valueOf(currWordChar);

                        if (wordSet.contains(temp)) {
                            if(temp.equals(endWord))
                                return step + 1;
                            
                            if (!visited.contains(temp)) {
                                queue.add(temp);
                                visited.add(temp);
                            }
                        }
                    }

                    currWordChar[j] = originWord;
                }
            }

            step++;
        }

        return 0;
    }
}
// @lc code=end

