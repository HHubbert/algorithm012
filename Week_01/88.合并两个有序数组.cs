/*
 * @lc app=leetcode.cn id=88 lang=csharp
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
public class Solution {

    //第一种，暴力解法，合并两个数组然后排序
    //第二种，分配额外的m的数组，使用两个指针从两个数组的开头开始比较
    //第三种，使用三个指针，两个数组从尾部开始比较
    public void Merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1 ; 
        int p2 = n - 1;
        int p = m + n - 1;

        while(p1 >= 0 && p2 >= 0) {
            int val1 = nums1[p1];
            int val2 = nums2[p2];

            nums1[p--] = val1 < val2 ? nums2[p2--] : nums1[p1--];
        }

        //防止最小的元素在nums2中
        Array.Copy(nums2, 0, nums1, 0, p2 + 1);
    }
}
// @lc code=end

