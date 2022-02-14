//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ['1','1','1','1','0'],
//  ['1','1','0','1','0'],
//  ['1','1','0','0','0'],
//  ['0','0','0','0','0']
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ['1','1','0','0','0'],
//  ['1','1','0','0','0'],
//  ['0','0','1','0','0'],
//  ['0','0','0','1','1']
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 
// 👍 1345 👎 0

package leetcode.editor.cn;
//Java：岛屿数量
class P200NumberOfIslands{
    public static void main(String[] args) {
        Solution solution = new P200NumberOfIslands().new Solution();
        // TO TEST
        char [][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(solution.numIslands(grid));
        System.out.println(grid.toString());
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[][] move = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        for(int i=0 ; i<height ; i++) {
            for (int j=0 ; j<width ; j++) {
                if(grid[i][j] == '1') {
                    DFS(grid, i, j);
                    grid[i][j] = '1';
                }
            }
        }
        int count = 0;
        for(int i=0 ; i<height ; i++) {
            for (int j=0 ; j<width ; j++) {
                if(grid[i][j] == '1') {
                    count++;
                }
            }
        }

        return count;

    }

    public void DFS(char[][] grid, int start_i, int start_j) {

        if (start_j<0 || start_i<0
                || start_j >= grid[0].length || start_i >= grid.length
                || grid[start_i][start_j] == '0')
            return;
        for(int i=0 ; i<move.length ; i++) {
            if (!(start_j<0 || start_i<0 || start_j >= grid[0].length || start_i >= grid.length)) {
                System.out.println(start_i+move[i][0]);
                System.out.println(start_j+move[i][1]);
                DFS(grid, start_i+move[i][0], start_j+move[i][1]);
                grid[start_i][start_j] = '0';
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
