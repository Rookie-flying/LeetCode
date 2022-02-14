//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1493 👎 0


package leetcode.editor.cn;


/**
 * @author hx
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    static class Solution {

        public void test() {

            System.out.println("test");
        }

        public String minWindow(String s, String t) {

            if (s == null || s.length() == 0 || t == null || t.length() == 0){
                return "";
            }

            int left = 0;
            int right = 0;
            int count = t.length();
            int size = Integer.MAX_VALUE;
            int start = 0;

            //ascii 总共128个，包含了大小写
            int[] arr = new int[128];

            for (Character c : t.toCharArray()) {

                arr[c]++;
            }


            while (right < s.length()) {

                char c = s.charAt(right);

                if (arr[c] > 0) {
                    count--;
                }
                arr[c]--;

                if (count == 0) {

                    while (arr[s.charAt(left)] < 0) {

                        arr[s.charAt(left)]++;
                        left++;
                    }

                    if (right - left + 1 < size) {

                        size = right - left + 1;
                        start = left;
                    }

                    arr[s.charAt(left)]++;
                    left++;
                    count++;
                }

                right++;

            }

            return size == Integer.MAX_VALUE ? "1" : s.substring(start, start+size);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}