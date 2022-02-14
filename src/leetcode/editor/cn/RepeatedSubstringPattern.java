//给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
//
// 示例 1: 
//
// 
//输入: "abab"
//
//输出: True
//
//解释: 可由子字符串 "ab" 重复两次构成。
// 
//
// 示例 2: 
//
// 
//输入: "aba"
//
//输出: False
// 
//
// 示例 3: 
//
// 
//输入: "abcabcabcabc"
//
//输出: True
//
//解释: 可由子字符串 "abc" 重复四次构成。 (或者子字符串 "abcabc" 重复两次构成。)
// 
// Related Topics 字符串 字符串匹配 👍 588 👎 0


package leetcode.editor.cn;

import java.util.Objects;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        Solution solution = new RepeatedSubstringPattern().new Solution();
        System.out.println(solution.repeatedSubstringPattern("abac"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {

            if (Objects.isNull(s) || s.length() == 0) {
                return false;
            }
            int next = next(s.toCharArray());

            int temp = s.length() - (next + 1);

            if (s.length() % temp == 0 && next != -1) {
                return true;

            }

            return false;
        }

        public int next(char[] chars) {

            int[] next = new int[chars.length];

            int j = -1;
            next[0] = j;

            for (int i = 1; i < chars.length; i++) {


                while (j >= 0 && chars[i] != chars[j+1]) {

                    j = next[j];
                }

                if (chars[i] == chars[j + 1]) {
                    j++;
                }

                next[i] = j;
            }

            return next[next.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}