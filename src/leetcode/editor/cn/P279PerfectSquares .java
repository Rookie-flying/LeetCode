//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 104 
// 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 1092 👎 0

package leetcode.editor.cn;
//Java：完全平方数
class P279PerfectSquares{
    public static void main(String[] args) {
        Solution solution = new P279PerfectSquares().new Solution();
        solution.numSquares(12);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int min = Integer.MAX_VALUE;
        public int numSquares(int n) {
            int mid = (int)Math.sqrt(n);
            dfs(n, mid, 0);
            System.out.println(min);
            return min;
        }

        public void dfs(int target, int mid, int count) {

            if (target == 0) {
                if (min > count)
                    min = count;
                return;
            }
            for(int i=mid ; i>1 ; i--) {

                if(target > 0) {
                    dfs(target-i*i, i, ++count);
                } else {
                    return;
                }
                count--;
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
