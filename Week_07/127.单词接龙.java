import java.util.ArrayDeque;
import java.util.HashSet;
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
        if(!wordSet.contains(endWord)) return 0;
        wordSet.remove(beginWord);

        Queue<String> queue = new ArrayDeque<>();
        Queue<String> visited = new ArrayDeque<>();

        queue.offer(beginWord);
        visited.offer(beginWord);
        
        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();

                char[] wordsArray = word.toCharArray();
                for(int j = 0; j < wordsArray.length; j++) {
                    char original = wordsArray[j];

                    for(char k = 'a'; k <= 'z'; k++ ) {
                        if(k == original) continue;

                        wordsArray[j] = k;
                        String currString = String.valueOf(wordsArray);
                        if(wordSet.contains(currString)) {
                            if(currString.equals(endWord))
                                return step + 1;
                            if(!visited.contains(currString)) {
                                queue.offer(currString);
                                visited.offer(currString);
                            }
                        }
                    }

                    wordsArray[j] = original;
                }
            }
            step++;
        }

        return 0;
    }
}
// @lc code=end

