////统计一个数字在排序数组中出现的次数。
////
//// 
////
//// 示例 1: 
////
//// 
////输入: nums = [5,7,7,8,8,10], target = 8
////输出: 2 
////
//// 示例 2: 
////
//// 
////输入: nums = [5,7,7,8,8,10], target = 6
////输出: 0 
////
//// 
////
//// 提示： 
////
//// 
//// 0 <= nums.length <= 10⁵ 
//// -10⁹ <= nums[i] <= 10⁹ 
//// nums 是一个非递减数组 
//// -10⁹ <= target <= 10⁹ 
//// 
////
//// 
////
//// 注意：本题与主站 34 题相同（仅返回值不同）：https://leetcode-cn.com/problems/find-first-and-
//last-
////position-of-element-in-sorted-array/ 
//// Related Topics 数组 二分查找 👍 223 👎 0
//

package leetcode.editor.cn;

public class ZaiPaiXuShuZuZhongChaZhaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new ZaiPaiXuShuZuZhongChaZhaoShuZiLcof().new Solution();
        System.out.println(solution.search(new int[]{5,7,7,8,8,10}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {

            int len = nums.length;
            int left = 0;
            int right = len - 1;

            int mid = 0;
            while (left < right) {

                mid = left + ((right - left) >> 1);
                if (nums[mid] >= target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }

            int count = 0;
            while (left < len && nums[left++] == target) {
                count++;
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}