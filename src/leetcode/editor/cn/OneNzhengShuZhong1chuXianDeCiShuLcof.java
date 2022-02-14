//输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
//
// 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：5
// 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：6 
//
// 
//
// 限制： 
//
// 
// 1 <= n < 2^31 
// 
//
// 注意：本题与主站 233 题相同：https://leetcode-cn.com/problems/number-of-digit-one/ 
// Related Topics 递归 数学 动态规划 👍 248 👎 0


package leetcode.editor.cn;

public class OneNzhengShuZhong1chuXianDeCiShuLcof {
    public static void main(String[] args) {
        Solution solution = new OneNzhengShuZhong1chuXianDeCiShuLcof().new Solution();
        System.out.println(solution.countDigitOne(824883294));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countDigitOne(int n) {

            int res = 0;
            long i = 1;
            while (n/i != 0) {
                long high = n / (10 * i);
                long cur = (n / i) % 10;
                long low = n - (n / i) * i;

                if (cur == 0) {
                    res += (i * high);
                } else if (cur == 1) {
                    res += (i * high) + low + 1;
                } else {
                    res += (high+1)*i;
                }
                i = i*10;
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}