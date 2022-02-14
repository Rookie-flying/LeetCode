//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 715 👎 0

package leetcode.editor.cn;
//Java：最短无序连续子数组
class P581ShortestUnsortedContinuousSubarray{
    public static void main(String[] args) {
        Solution solution = new P581ShortestUnsortedContinuousSubarray().new Solution();
        // TO TEST
        int[] nums = {1,2,3,3,3};
        System.out.println(solution.findUnsortedSubarray(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int l = -1;
        int r = -1;

        int n = nums.length;

        for (int i=0 ; i<n ; i++) {

            if (max > nums[i]) {
                r = i;
            } else {
                max = nums[i];
            }

            if (min < nums[n-i-1]) {
                l = n-i-1;
            } else {
                min = nums[n-i-1];
            }
        }

        return r == -1 ? 0 : r-l+1;
        /**
         *  自己解法
         *  if (nums.length <= 1) {
         *             return 0;
         *         }
         *
         *         int l = 0;
         *         int r = nums.length-1;
         *
         *         while (l < r ) {
         *             boolean flag_l = true;
         *             boolean flag_r = true;
         *             for(int i=l ; i<=r ; i++) {
         *
         *                 if (nums[i] < nums[l]) {
         *                     flag_l = false;
         *                 }
         *
         *                 if (nums[i] > nums[r]) {
         *                     flag_r = false;
         *                 }
         *
         *                 if ( !flag_l && !flag_r) {
         *                     break;
         *                 }
         *             }
         *
         *             if (flag_l) {
         *                 l++;
         *             }
         *
         *             if (flag_r) {
         *                 r--;
         *             }
         *
         *             if ( !flag_l && !flag_r) {
         *                 break;
         *             }
         *         }
         *
         *         if (r-l == 0) {
         *             return 0;
         *         } else {
         *             return r-l+1;
         *         }
         */

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
