//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。 
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1293 👎 0

package leetcode.editor.cn;
//Java：乘积最大子数组
class P152MaximumProductSubarray{
    public static void main(String[] args) {
        Solution solution = new P152MaximumProductSubarray().new Solution();
        // TO TEST
        int [] arr = {-4, -3, -2};
        solution.maxProduct(arr);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        //动态规划
        int max = nums[0];
        int min = nums[0];
        int res = Math.max(max, min);
        for(int i=1 ; i<nums.length-1 ; i++) {
            max = Math.max(max*nums[i], Math.max(nums[i], min*nums[i]));
            min = Math.min(max*nums[i], Math.min(nums[i], min*nums[i]));
            res = Math.max(max, Math.max(min, res));

        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
