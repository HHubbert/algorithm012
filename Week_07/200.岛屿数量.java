//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 677 👎 0


//Java：岛屿数量
class P200NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST

    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIslands(char[][] grid) {
        int numOfIslands = 0;
        int row = grid.length;
        if(row == 0) return 0;
        int col = grid[0].length;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    DFSRemoveIslands(i, j, row, col, grid);
                    numOfIslands++;
                }
            }
        }

        return numOfIslands;
    }

        private void DFSRemoveIslands(int i, int j, int row, int col, char[][] grid) {
            if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == '0') return;;
            grid[i][j] = '0';
            DFSRemoveIslands(i + 1, j, row, col, grid);
            DFSRemoveIslands(i , j + 1, row, col, grid);
            DFSRemoveIslands(i - 1, j, row, col, grid);
            DFSRemoveIslands(i , j - 1, row, col, grid);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
