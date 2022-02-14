//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 👍 543 👎 0


package leetcode.editor.cn;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {

            int[][] arr = new int[n][n];

            int left = 0, right = n-1, top = 0, bottom = n-1;
            int count = 1;

            while (count <= n*n) {

                for (int k = left; k <=right ; k++) {

                    arr[top][k] = count++;
                }
                top++;

                for (int i = top; i <=bottom ; i++) {

                    arr[i][right] = count++;
                }
                right--;

                for (int i = right; i >= left ; i--) {

                    arr[bottom][i] = count++;
                }
                bottom--;

                for (int i = bottom; i >= top ; i--) {

                    arr[i][left] = count++;
                }
                left++;
            }

            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}