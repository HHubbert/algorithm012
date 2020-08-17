/*
 * @lc app=leetcode.cn id=64 lang=java
 *
 * [64] 最小路径和
 */

// @lc code=start
class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        int [][] output = new int[rows][columns];
        output[0][0] = grid[0][0];

        for(int i = 1 ; i < rows ; i++) {
            output[i][0] = output[i-1][0] + grid[i][0];
        }

        for(int j = 1; j < columns; j++) {
            output[0][j] = output[0][j-1] + grid[0][j];
        }

        for(int i = 1; i < rows; i++) {
            for(int j = 1; j < columns; j++ ) {
                output[i][j] = Math.min(output[i][j-1], output[i-1][j]) + grid[i][j];
            }
        }

        int result = output[rows-1][columns-1];

        return result;
    }
}
// @lc code=end

