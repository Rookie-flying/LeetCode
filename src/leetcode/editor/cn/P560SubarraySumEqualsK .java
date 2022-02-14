//给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// -107 <= k <= 107 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 1126 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：和为 K 的子数组
class P560SubarraySumEqualsK{
    public static void main(String[] args) {
        Solution solution = new P560SubarraySumEqualsK().new Solution();
        // TO TEST
        int[] nums = {-1,-1,1};
        int target = 1;

        System.out.println(solution.subarraySum(nums, target));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int big = 0;
        map.put(0, 1);
        for (int i=0 ; i<nums.length ; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                big += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return big;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
