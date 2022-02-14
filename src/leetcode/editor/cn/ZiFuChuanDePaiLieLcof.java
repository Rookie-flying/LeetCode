//输入一个字符串，打印出该字符串中字符的所有排列。
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 字符串 回溯 👍 446 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZiFuChuanDePaiLieLcof {
    public static void main(String[] args) {
        Solution solution = new ZiFuChuanDePaiLieLcof().new Solution();
        solution.permutation("aca");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<String> list = new ArrayList<>();
        public String[] permutation(String s) {

            StringBuilder stringBuilder = new StringBuilder(s);
            boolean[] visited = new boolean[s.length()];
            dfs(stringBuilder, new StringBuilder(), visited);

            return  list.toArray(new String[0]);
        }

        public void dfs(StringBuilder s, StringBuilder res, boolean[] visited) {

            if (res.length() == s.length()) {
                list.add(res.toString());
                return;
            }

            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0 ; j<s.length() ; j++) {
                if (visited[j])
                    continue;
                if (map.size() != 0 && map.get(s.charAt(j)) != null)
                    continue;
                visited[j] = true;
                res.append(s.charAt(j));
                dfs(s, res, visited);
                map.put(res.charAt(res.length() - 1), 1);
                res.deleteCharAt(res.length() - 1);
                visited[j] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}