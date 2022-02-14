//从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，
//可以看成任意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 
//输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// Related Topics 数组 排序 👍 178 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BuKePaiZhongDeShunZiLcof {
    public static void main(String[] args) {
        Solution solution = new BuKePaiZhongDeShunZiLcof().new Solution();
        System.out.println(solution.isStraight(new int[]{0,0,2,3,5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isStraight(int[] nums) {

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            Set<Integer> set = new HashSet<>();
            for (int j=0 ; j<nums.length ; j++) {
                if (nums[j] == 0) continue;
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                if (set.contains(nums[j])) {
                    return false;
                }
                set.add(nums[j]);
            }

            return max - min >= 5 ? false : true ;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}