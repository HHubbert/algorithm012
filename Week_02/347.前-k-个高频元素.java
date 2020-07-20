import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import sun.nio.cs.KOI8_U;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    //1. 用哈希表保持每个数字出现的次数
    //2. 用优先级队列按照次数的大小从小到大排序
    //3. 如果size() > k，则将顶堆弹出
    //4. 最后遍历弹出优先级队列即可
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1,n2)-> map.get(n1) - map.get(n2));
    
        for(int n : map.keySet()) {
            heap.add(n);
            if(heap.size() > k)
                heap.poll();
        }

        int [] result = new int[k];
        for(int i = 0 ; i < k; i++) {
            result[i] = heap.poll();
        }

        return result;
    }
}
// @lc code=end

