import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] 数组的相对排序
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        int index = 0;
        for(int num1 : arr1) 
            cnt[num1]++;    

        for(int num2 : arr2) {
            while(cnt[num2]-- > 0) 
                arr1[index++] = num2;
        }

        for(int i = 0; i < cnt.length; i++) {
            while(cnt[i]-- > 0) {
                arr1[index++] = i;
            }
        }

        return arr1;
    }
}
// @lc code=end

