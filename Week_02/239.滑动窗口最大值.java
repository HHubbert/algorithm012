import java.util.ArrayDeque;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */

// @lc code=start
class Solution {

    
    ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
    int [] nums;

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n*k == 0) return new int[]{};
        this.nums = nums;

        int max_index = 0;
        for (int i = 0 ; i < k ; i++) {
            clean_deque(i, k);
            deque.addLast(i);

            if(nums[i] > nums[max_index])
                max_index = i;
        }

        int [] output = new int[n - k + 1];
        output[0] = nums[max_index];

        for (int i = k ; i < n; i++) {
            clean_deque(i, k);
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }

        return output;
    }

    public void clean_deque(int i , int k){
        if(!deque.isEmpty() && deque.getFirst() == i - k)
            deque.removeFirst();

        while(!deque.isEmpty() && nums[deque.getLast()] < nums[i])
            deque.removeLast();
    }
}
// @lc code=end

