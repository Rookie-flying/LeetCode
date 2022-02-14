//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。 
//
// 回文字符串 是正着读和倒过来读一样的字符串。 
//
// 子字符串 是字符串中的由连续字符组成的一个序列。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 691 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

//Java：回文子串
class P647PalindromicSubstrings{
    public static void main(String[] args) {
        Solution solution = new P647PalindromicSubstrings().new Solution();
        // TO TEST
        String s = "aaa";
        System.out.println(solution.countSubstrings("aba"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubstrings(String s) {

        // 方法二，中心点法，找到中心点，再由内到外扩充，看是否是回文串
        //abba 有7个中心点，分别是 a ab b bb b ba a  n=2*s.length-1

        int left = 0;
        int right = 0;
        int res = 0;
        for (int i=0 ; i<2*s.length() - 1 ; i++) {

            left = i / 2;
            right = left + i%2; //考虑一个数的中心点，和两个数的中心点

            while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

                res++;
                left--;
                right++;
            }
        }

        return res;



//       //方法一 dp[i][j]：i到j的字符串是否是回文串，从零开始
//        // dp[i][j] = s[i]==s[j] && (j-i<2 || s[i++][j--])
//
//
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        int res = 0;
//        for(int j=0 ; j<s.length() ; j++) {
//
//            for(int i=0 ; i<=j ; i++) {
//
//                if (s.charAt(j) == s.charAt(i) && (j-i<2 || dp[i+1][j-1])) {
//                    dp[i][j] = true;
//                    res++;
//                }
//            }
//        }
//
//        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
