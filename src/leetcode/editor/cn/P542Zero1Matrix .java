//给定一个由 0 和 1 组成的矩阵 mat ，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。 
//
// 两个相邻元素间的距离为 1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[0,0,0]]
//输出：[[0,0,0],[0,1,0],[0,0,0]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：mat = [[0,0,0],[0,1,0],[1,1,1]]
//输出：[[0,0,0],[0,1,0],[1,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 104 
// 1 <= m * n <= 104 
// mat[i][j] is either 0 or 1. 
// mat 中至少有一个 0 
// 
// Related Topics 广度优先搜索 数组 动态规划 矩阵 
// 👍 530 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

//Java：01 矩阵
class P542Zero1Matrix{
    public static void main(String[] args) {
        Solution solution = new P542Zero1Matrix().new Solution();
        // TO TEST
        int[][] mat = {{0,0,0},{0,1,0},{1,1,1}};
        solution.updateMatrix(mat);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        //DP
        int row = mat.length;
        int col = mat[0].length;
        int[][] dp = new int[row][col];

        for(int i=0 ; i<row ; i++) {
            for (int j=0 ; j<col ; j++) {
                if (mat[i][j] != 0) {
                    dp[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }

        //水平左移，竖直向上移动
        for(int i=0 ; i<row ; i++) {
            for(int j=0 ; j<col; j++) {

                if(i-1>=0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]+1);
                }
                if(j-1>=0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]+1);
                }
            }
        }

        for (int i=row-1 ; i>=0 ; i--) {
            for (int j=col-1 ; j>=0 ; j--) {

                if (i+1 < row) {
                    dp[i][j] = Math.min(dp[i][j], dp[i+1][j]+1);
                }
                if (j+1 < col) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j+1]+1);
                }
            }
        }

        return dp;

/*        //BFS
        int row = mat.length;
        int col = mat[0].length;
        boolean[][] visit = new boolean[row][col];
        Queue<int[]> queue = new LinkedList<>();

        int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i=0 ; i<row ; i++) {

            for (int j=0 ; j<col ; j++) {

                if (mat[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {

            int[] temp = queue.poll();
            for(int i=0 ; i<4 ; i++) {

                int temp_row = temp[0] + direction[i][0];
                int temp_col = temp[1] + direction[i][1];
                if (temp_col>=0 && temp_row>=0
                        && temp_col<col && temp_row<row
                        && !visit[temp_row][temp_col]) {
                    mat[temp_row][temp_col] = mat[temp[0]][temp[1]] + 1;
                    queue.offer(new int[]{temp_row, temp_col});
                    visit[temp_row][temp_col] = true;
                }
            }
        }

        return mat;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
