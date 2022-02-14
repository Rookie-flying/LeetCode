//写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
//
// 
//
// 示例: 
//
// 输入: a = 1, b = 1
//输出: 2 
//
// 
//
// 提示： 
//
// 
// a, b 均可能是负数或 0 
// 结果不会溢出 32 位整数 
// 
// Related Topics 位运算 数学 👍 233 👎 0


package leetcode.editor.cn;

public class BuYongJiaJianChengChuZuoJiaFaLcof {
    public static void main(String[] args) {
        Solution solution = new BuYongJiaJianChengChuZuoJiaFaLcof().new Solution();
        System.out.println(solution.add(1 , 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int add(int a, int b) {

            int num1 = a & b;
            int num2 = a ^ b;

            while (num1 != 0) {

                int e = num1 << 1;
                int f = num2;

                num1 = e & f;
                num2 = f ^ e;
            }

            return num2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}