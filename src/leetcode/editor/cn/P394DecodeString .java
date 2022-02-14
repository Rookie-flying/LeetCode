//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 
//
// 示例 1： 
//
// 输入：s = "3[a]2[bc]"
//输出："aaabcbc"
// 
//
// 示例 2： 
//
// 输入：s = "3[a2[c]]"
//输出："accaccacc"
// 
//
// 示例 3： 
//
// 输入：s = "2[abc]3[cd]ef"
//输出："abcabccdcdcdef"
// 
//
// 示例 4： 
//
// 输入：s = "abc3[cd]xyz"
//输出："abccdcdcdxyz"
// 
// Related Topics 栈 递归 字符串 
// 👍 897 👎 0

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Stack;

//Java：字符串解码
class P394DecodeString{
    public static void main(String[] args) {
        Solution solution = new P394DecodeString().new Solution();
        // TO TEST
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
        System.out.println(solution.decodeString("3[a2[c]]"));
        System.out.println(solution.decodeString("abc3[cd]xyz"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String decodeString(String s) {
        int mutil = 0;
        Stack<String> stack = new Stack<>();
        String res = "";
        for(Character item : s.toCharArray()) {
            if(item == '[') {
                String temp = mutil + "," + res;
                stack.push(temp);
                res = "";
                mutil = 0;
            } else if (item >= '0' && item <= '9') {
                mutil = mutil*10+Integer.parseInt(item+"");
            } else if (item == ']') {
                String[] num = stack.pop().split(",");
                String temp_res = "";
                for(int i=0 ; i<Integer.parseInt(num[0]) ; i++) {
                    temp_res += res;
                }
                if (num.length == 2)
                    res = num[1] + temp_res;
                else
                    res = temp_res;
            } else {
                res = res+item;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
