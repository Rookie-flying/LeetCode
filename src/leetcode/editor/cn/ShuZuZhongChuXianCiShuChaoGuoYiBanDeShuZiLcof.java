//数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
//
// 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
//输出: 2 
//
// 
//
// 限制： 
//
// 1 <= 数组长度 <= 50000 
//
// 
//
// 注意：本题与主站 169 题相同：https://leetcode-cn.com/problems/majority-element/ 
//
// 
// Related Topics 数组 哈希表 分治 计数 排序 👍 216 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongChuXianCiShuChaoGuoYiBanDeShuZiLcof().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {

/*            Map<Integer, Integer> hasMap = new HashMap<>();

            for (int num : nums) {

                hasMap.put(num, hasMap.getOrDefault(num, 0)+1);
                if (hasMap.get(num) > nums.length >> 1) {
                    return num;
                }
            }*/

            int vote = 0;
            int res = 0;
            for (int i = 0; i < nums.length; i++) {

                if (vote == 0) {

                    res = nums[i];
                    vote += 1;
                } else if (nums[i] == res) {
                    vote += 1;
                } else if (nums[i] != res) {
                    vote -= 1;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}