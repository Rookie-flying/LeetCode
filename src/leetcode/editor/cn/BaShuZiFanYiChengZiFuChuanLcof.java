//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。 
//
// 
//
// 示例 1: 
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi" 
//
// 
//
// 提示： 
//
// 
// 0 <= num < 2³¹ 
// 
// Related Topics 字符串 动态规划 👍 324 👎 0


package leetcode.editor.cn;

public class BaShuZiFanYiChengZiFuChuanLcof {
    public static void main(String[] args) {
        Solution solution = new BaShuZiFanYiChengZiFuChuanLcof().new Solution();
        System.out.println(solution.translateNum(100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int translateNum(int num) {

            final String s = String.valueOf(num);
            int len = s.length();

            int[] dp = new int[len+1];
            dp[0] = 1;
            for (int i = 1 ; i <= len ; i++) {

                //当前字符不能与前一个位组成翻译
                dp[i] = dp[i - 1];

                if (i > 1) {

                    int temp = (s.charAt(i-1) - '0') + (s.charAt(i-2) - '0')*10;
                    //能够组成一个数，因此把这两个数当成一位数字
                    if (temp >= 10 && temp <=25) {
                        dp[i] += dp[i - 2];
                    }
                }
            }

            return dp[len];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}