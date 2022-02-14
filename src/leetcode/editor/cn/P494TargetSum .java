//给你一个整数数组 nums 和一个整数 target 。 
//
// 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ： 
//
// 
// 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。 
// 
//
// 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1,1,1], target = 3
//输出：5
//解释：一共有 5 种方法让最终目标和为 3 。
//-1 + 1 + 1 + 1 + 1 = 3
//+1 - 1 + 1 + 1 + 1 = 3
//+1 + 1 - 1 + 1 + 1 = 3
//+1 + 1 + 1 - 1 + 1 = 3
//+1 + 1 + 1 + 1 - 1 = 3
// 
//
// 示例 2： 
//
// 
//输入：nums = [1], target = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 20 
// 0 <= nums[i] <= 1000 
// 0 <= sum(nums[i]) <= 1000 
// -1000 <= target <= 1000 
// 
// Related Topics 数组 动态规划 回溯 
// 👍 916 👎 0

package leetcode.editor.cn;

import java.util.Date;
import java.util.Map;

//Java：目标和
class P494TargetSum{
    public static void main(String[] args) {
        Solution solution = new P494TargetSum().new Solution();
        // TO TEST
        int[] nums = {0,0,0,0,0,0,0,0,1};
        int target = 1;
        System.out.println(solution.findTargetSumWays(nums, target));

    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findTargetSumWays(int[] nums, int target) {

            //dp，类比背包问题
            int sum = 0;
            for (int i=0 ; i<nums.length ; i++) {
                sum += nums[i];
            }

            //如果sum<target 不符合
            if (Math.abs(target) > Math.abs(sum)) {
                return 0;
            }

            //由于要考虑target为负数的情况,所以[-sum, sum]，实际上就是[0, 2*sum+1]，为零的情况加一
            int column = 2*sum + 1;
            int[][] dp = new int[nums.length][column];

            //初始化，dp[0][]，即nums[0].以sum为中点, 当nums[0] == 0，dp[0][sum] = 2
            dp[0][sum+nums[0]] += 1;
            dp[0][sum-nums[0]] += 1;

            //dp[i][j]
            //到nums数组中nums[i]数为止，满足和为j的情况
            for(int i=1 ; i<nums.length ; i++) {
                for(int j=-sum ; j<=sum ; j++) {
                    //边界
                    if (nums[i] + j > sum) {
                        dp[i][j+sum] = dp[i-1][j+sum-nums[i]] + 0;
                    } else if ( j - nums[i] < -sum) {
                        dp[i][j+sum] = dp[i-1][j+sum+nums[i]] + 0;
                    } else {
                        dp[i][j+sum] = dp[i-1][j+sum-nums[i]] + dp[i-1][j+sum+nums[i]];
                    }
                }
            }
            return dp[nums.length-1][target+sum];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
