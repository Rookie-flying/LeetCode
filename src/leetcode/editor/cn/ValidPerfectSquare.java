//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 👍 323 👎 0


package leetcode.editor.cn;

public class ValidPerfectSquare {
    public static void main(String[] args) {
        Solution solution = new ValidPerfectSquare().new Solution();
        System.out.println(solution.isPerfectSquare(2147483647));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPerfectSquare(int num) {

            int left = 0;
            int right = num;
            int res = -1;

            while (left <= right) {

                int mid = left + ((right - left) >> 1);

                if ((long)mid*mid <= num) {
                    res = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return res*res == num ? true : false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}