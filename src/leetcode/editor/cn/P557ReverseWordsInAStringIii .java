//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 双指针 字符串 
// 👍 344 👎 0

package leetcode.editor.cn;
//Java：反转字符串中的单词 III
class P557ReverseWordsInAStringIii{
    public static void main(String[] args) {
        Solution solution = new P557ReverseWordsInAStringIii().new Solution();
        // TO TEST
        String s = "Let's take LeetCode contest";
        System.out.println(solution.reverseWords(s));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {

        StringBuffer stringBuffer = new StringBuffer();
        int len = s.length();

        int i=0;
        while (i < len) {

            int left = i;
            //找到空格
            while (i < len && ' ' != s.charAt(i)) {
                i++;
            }
            //逆向输入
            for (int start = i-1 ; start >= left ; start--) {
                stringBuffer.append(s.charAt(start));
            }
            //空格
            if ( i < len && ' ' == s.charAt(i)) {
                stringBuffer.append(" ");
            }
            i++;
        }

        return stringBuffer.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
