import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < inLen; i++) {
            map.put(inorder[i], i);
        }

        return bulidTree(preorder, 0, preLen - 1, map, 0, inLen - 1);
    }

    private TreeNode bulidTree(int[] preorder, int preLeft, int preRight, Map<Integer, Integer> map, int inLeft, int inRight) {
        if(preLeft > preRight || inLeft > inRight)
            return null;

        TreeNode root = new TreeNode(preorder[preLeft]);
        int inRootIndex = map.get(root.val);

        root.left = bulidTree(preorder, preLeft + 1, inRootIndex - inLeft + preLeft, map, inLeft, inRootIndex - 1);
        root.right = bulidTree(preorder, inRootIndex - inLeft + preLeft + 1, preRight, map, inRootIndex + 1, inRight);
        
        return root;
    }
}
// @lc code=end

