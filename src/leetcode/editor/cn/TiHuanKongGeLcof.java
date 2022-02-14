//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// Related Topics 字符串 👍 193 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Objects;

public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        System.out.println(solution.replaceSpace("we are happy"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceSpace(String s) {

            if (Objects.isNull(s) || s.length() == 0) {

                return "";
            }

            // 先扩充长度，即一个空格，相比之前，要扩充两个空格
            // left指向原始字符串最后
            // right指向扩充长度字符串的最后
            // left遇到空格 right就添加%20
            StringBuilder stringBuilder = new StringBuilder();

            for (char c : s.toCharArray()) {

                if (c == ' ') {

                    stringBuilder.append("  ");
                }
            }

            int left = s.length() - 1;
            s += stringBuilder.toString();
            int right = s.length() - 1;
            char[] chars = s.toCharArray();

            while (left >= 0) {

                if (chars[left] == ' ') {

                    chars[right--] = '0';
                    chars[right--] = '2';
                    chars[right] = '%';
                } else {
                    chars[right] = chars[left];
                }
                right--;
                left--;
            }
            return String.valueOf(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}