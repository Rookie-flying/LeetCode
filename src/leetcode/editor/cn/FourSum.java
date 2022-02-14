//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 1051 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new FourSum().new Solution();
        System.out.println(solution.fourSum(new int[]{-4,-3,-2,-1,0,0,1,2,3,4}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String test(String s) {

            s += "bbb";
            return s;
        }

        public List<List<Integer>> fourSum(int[] nums, int target) {

            String s = new String("ab");
            String ns = test(s);
            System.out.println(s);
            Arrays.sort(nums);

            List<List<Integer>> res = new ArrayList<>();

            for (int j = 0 ; j < nums.length; j++) {

                // 如果target为负数，此条件不成立
                // 多个负数相加，会更小
//                if (nums[j] > target) {
//                    return res;
//                }

                if (j > 0 && nums[j] == nums[j - 1]) {
                    continue;
                }

                for (int i = j + 1; i < nums.length; i++) {

//                    if (nums[i] > (target - nums[j])) {
//                        return res;
//                    }

                    if (i > j+1 && nums[i] == nums[i - 1]) {
                        continue;
                    }

                    int left = i + 1;
                    int right = nums.length - 1;
                    int temp = target - nums[i] - nums[j];

                    while (left < right) {

                        int sum = nums[left] + nums[right];
                        if (sum == temp) {
                            res.add(Arrays.asList(nums[j], nums[i], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            left++;
                            right--;
                        } else if (sum > temp) {
                            right--;
                        } else {
                            left++;
                        }
                    }
                }
            }
            return res;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}