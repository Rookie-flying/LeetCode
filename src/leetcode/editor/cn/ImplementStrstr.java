//实现 strStr() 函数。
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 10⁴ 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 字符串匹配 👍 1189 👎 0


package leetcode.editor.cn;

import java.util.Objects;

public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        System.out.println(solution.strStr("hello", "ll"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int strStr(String haystack, String needle) {

            if (Objects.isNull(needle) || needle.length() == 0) {
                return 0;
            }

            int[] next = new int[needle.length()];
            next(next, needle.toCharArray());

            int j = -1;
            for (int i = 0 ; i<haystack.length() ; i++) {

                while (j >= 0 && haystack.charAt(i) != needle.charAt(j+1)) {

                    j = next[j];
                }

                if (haystack.charAt(i) == needle.charAt(j + 1)) {
                    j++;
                }

                if (j == needle.length() - 1) {
                    return i - j;
                }
            }
            return -1;
        }

        public void next(int[] next, char[] chars) {

            int j = -1;
            next[0] = -1;

            for (int i = 1 ; i<chars.length ; i++) {

                while (j >= 0 && chars[i] != chars[j+1]) {

                    j = next[j];
                }

                if (chars[i] == chars[j + 1]) {
                    j++;
                }

                next[i] = j;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}