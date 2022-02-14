//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1302 👎 0

package leetcode.editor.cn;

import java.util.Random;

//Java：数组中的第K个最大元素
class P215KthLargestElementInAnArray{
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        int[] nums = {5,2,4,1,3,6,0};
        System.out.println(solution.findKthLargest(nums, 4));// TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        Random random = new Random();
        int flag = -1;
        public int findKthLargest(int[] nums, int k) {
            quickSort(nums, 0, nums.length-1, k);
            if (flag == -1)
                return nums[k-1];
            else
                return flag;
        }

        public void quickSort(int[] nums, int l, int r, int k) {
            if (l > r) {
                return;
            }
            int right = r;
            int left = l;
            int m = r-l+1;
            int head_index = random.nextInt(r-l+1)+left;
            swap(nums, l, head_index);
            int head = nums[l];
            while(left < right) {

                while(left<right && nums[right] <= head)
                    right--;
                nums[left] = nums[right];
                while(left<right && nums[left] >= head)
                    left++;
                nums[right] = nums[left];
            }
            nums[left] = head;
            if (head_index == k-1) {
                flag = nums[head_index];
            }
            quickSort(nums, l, right-1, k);
            quickSort(nums, right+1, r, k);
        }

        public void swap(int[] nums , int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
