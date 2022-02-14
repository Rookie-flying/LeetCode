//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。 
//
// 异位词 指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
// 
//
// 示例 2: 
//
// 
//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, p.length <= 3 * 104 
// s 和 p 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 625 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Java：找到字符串中所有字母异位词
class P438FindAllAnagramsInAString{
    public static void main(String[] args) {
        Solution solution = new P438FindAllAnagramsInAString().new Solution();
        System.out.println(solution.findAnagrams("baa", "aa"));
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int len_s = s.length();
        int len_p = p.length();

        char[] s_arr = s.toCharArray();
        char[] p_arr = p.toCharArray();

        int[] s_fre = new int[26];
        int[] p_fre = new int[26];

        // 统计p的字符频次
        for(char item : p_arr) {
            p_fre[item - 'a'] += 1;
        }

        //滑动窗口
        int left = 0;
        int right = 0;

        List<Integer> res = new ArrayList<>();
        while(right < len_s) {
            s_fre[s_arr[right] - 'a'] += 1;
            // 如果right向右移动，长度等于 p_len，进行更新
            while (right - left + 1 == len_p) {

                if (Arrays.equals(s_fre, p_fre)) {
                    res.add(left);
                }
                // 向左移动
                s_fre[s_arr[left] - 'a'] -= 1;
                left++;
            }
            right++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
