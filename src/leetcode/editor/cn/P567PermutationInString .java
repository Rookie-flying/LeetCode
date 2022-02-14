//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 470 👎 0

package leetcode.editor.cn;
//Java：字符串的排列
class P567PermutationInString{
    public static void main(String[] args) {
        Solution solution = new P567PermutationInString().new Solution();
        // TO TEST
        System.out.println(solution.checkInclusion("ab", "eidboaoo"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        char[] s1_char = s1.toCharArray();
        char[] s2_char = s2.toCharArray();

        int left = 0;
        int right = 0;

        int[] target = new int[26];
        int[] wind = new int[26];

        for(int i=0 ; i<s1.length() ; i++) {
            ++target[s1_char[i] - 'a'];
        }

        int count = 0; // 统计种类数
        for(int item : target) {
            if (item > 0) {
                ++count;
            }
        }

        int pCount = 0;
        while(right < s2.length()) {

            // 从左到右，找到最大的能够包含s1的序列, 右边扩展
            if(target[s2_char[right] - 'a'] > 0) {
                ++wind[s2_char[right] - 'a'];

                if (wind[s2_char[right] - 'a'] == target[s2_char[right] - 'a']) {
                    ++pCount;
                }
            }
            right++;

            // 种类总数和每个种类的数量都与target一致时，判断长度，即是否挨着
            while (pCount == count) {

                if (right - left == s1.length()) {
                    return true;
                }

                // 左边收缩
                if (target[s2_char[left] - 'a'] > 0) {
                    --wind[s2_char[left] - 'a'];

                    if (wind[s2_char[left] - 'a'] < target[s2_char[left] - 'a']) {
                        --pCount;
                    }
                }
                left++;
            }

        }
        return false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
