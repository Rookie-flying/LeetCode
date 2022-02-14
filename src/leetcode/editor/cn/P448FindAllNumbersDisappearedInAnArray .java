//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 哈希表 
// 👍 828 👎 0

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：找到所有数组中消失的数字
class P448FindAllNumbersDisappearedInAnArray{
    public static void main(String[] args) {
        Solution solution = new P448FindAllNumbersDisappearedInAnArray().new Solution();
        // TO TEST
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(solution.findDisappearedNumbers(nums));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {

        //由于数组中的数字都是在nums.length内，理想情况下，每个元素-1，刚好组成索引下标
        //因此我们把每个元素-1，当成索引下标，并对索引对应的元素进行标记，
        //如果没有标记的元素的索引，即就是该数组的欠缺的元素-1

        List<Integer> list = new ArrayList<>();

        for(int num : nums) {
            int x = Math.abs(num);
            if (nums[x-1] > 0)
                nums[x-1] *= -1;
        }
        for(int i=0 ; i<nums.length ; i++) {
            if(nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
