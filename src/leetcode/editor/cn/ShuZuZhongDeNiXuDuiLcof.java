//在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
//
// 
//
// 示例 1: 
//
// 输入: [7,5,6,4]
//输出: 5 
//
// 
//
// 限制： 
//
// 0 <= 数组长度 <= 50000 
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 558 👎 0


package leetcode.editor.cn;

public class ShuZuZhongDeNiXuDuiLcof {
    public static void main(String[] args) {
        Solution solution = new ShuZuZhongDeNiXuDuiLcof().new Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int count = 0;
        public int reversePairs(int[] nums) {
            //归并排序
            //在归并排序，先分再合并
            //在合并的时候统计逆序对

            merge(nums, 0, nums.length - 1);
            return count;
        }

        /**
         * 分割数组，直至长度为1
         * @param nums
         * @param left
         * @param right
         */
        public void merge(int[] nums ,int left, int right) {

            int mid = left + ((right - left) >> 1);
            if (left < right) {

                merge(nums, left, mid);
                merge(nums, mid+1, right);
                //切分完，再进行合并
                mergeSort(nums, left, right, mid);
            }
        }

        public void mergeSort(int[] nums, int left, int right, int mid) {

            int[] tempArr = new int[right - left + 1];
            int temp1 = left;
            int temp2 = mid+1;

            int index = 0;
            while (temp2 <= right && temp1 <= mid) {

                if (nums[temp1] > nums[temp2]) {
                    count += (mid - temp1 + 1);
                    tempArr[index++] = nums[temp2++];
                } else {
                    tempArr[index++] = nums[temp1++];
                }
            }

            //如果left还未走完
            while (temp1 <= mid) {
                tempArr[index++] = nums[temp1++];
            }

            //如果right还未走完
            while (temp2 <= right) {
                tempArr[index++] = nums[temp2++];
            }

            //将tempArr复制回nums
            for(int i=left ; i<=right ; i++) {
                nums[i] = tempArr[i - left];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}