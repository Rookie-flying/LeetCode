//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1310 👎 0


package leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        System.out.println(solution.searchRange(new int[]{5}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {

            int left = 0;
            int right = nums.length - 1;
            int[] res = new int[]{-1, -1};
            if (nums.length == 0) {
                return res;
            }
            while (left <= right) {

                int mid = left + ((right - left) >> 1);

                if (nums[mid] >= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int temp = right + 1;
            if (temp < nums.length && nums[temp] == target)
                res[0] = temp;
            while (temp < nums.length && nums[temp] == target) {
                temp++;
            }
            if (temp-1 < nums.length && temp - 1 >= 0 &&  nums[temp-1] == target)
                res[1] = temp - 1;

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}