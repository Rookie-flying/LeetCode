//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
//
// 示例 1: 
//
// 
//输入：s = "abaccdeff"
//输出：'b'
// 
//
// 示例 2: 
//
// 
//输入：s = "" 
//输出：' '
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 队列 哈希表 字符串 计数 👍 152 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
        solution.firstUniqChar("leetcode");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char firstUniqChar(String s) {

            Map<Character, Integer> map = new LinkedHashMap<>();

            final char[] chars = s.toCharArray();

            for (char item : chars) {

                map.put(item, map.getOrDefault(item, 0)+1);
            }

            for (Map.Entry<Character, Integer> item : map.entrySet()) {

                if (item.getValue() == 1) {

                    return item.getKey();
                }
            }

            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}