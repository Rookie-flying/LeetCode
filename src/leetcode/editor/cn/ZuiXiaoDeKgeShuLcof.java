//////输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
//////
//////
//////
////// 示例 1：
//////
////// 输入：arr = [3,2,1], k = 2
//////输出：[1,2] 或者 [2,1]
//////
//////
////// 示例 2：
//////
////// 输入：arr = [0,1,2,1], k = 1
//////输出：[0]
//////
//////
//////
////// 限制：
//////
//////
////// 0 <= k <= arr.length <= 10000
////// 0 <= arr[i] <= 10000
//////
////// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 323 👎 0
////
//


package leetcode.editor.cn;

import java.util.Random;

public class ZuiXiaoDeKgeShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
        solution.getLeastNumbers(new int[]{0, 1, 2, 1, 9, 10, 11, 5, 3, 6}, 4);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Random random = new Random();
        public int[] getLeastNumbers(int[] arr, int k) {
            quickSort(arr, 0, arr.length-1, k);
            int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = arr[i];
            }
            return res;
        }

        public void quickSort(int[] arr, int left, int right, int k) {

            if (left > right) {
                return;
            }
            int l = left;
            int r = right;
            int headIndex = random.nextInt(right - left + 1) + left;
            swap(arr, left, headIndex);
            int head = arr[left];
            while (left < right) {

                while (left < right && head <= arr[right])
                    --right;
                arr[left] = arr[right];
                while (left < right && head >= arr[left])
                    ++left;
                arr[right] = arr[left];
            }
            arr[left] = head;
            if (k - 1 == left) {
                return;
            }
            quickSort(arr, l, left-1, k);
            quickSort(arr, left+1, r, k);
        }

        public void swap(int[] arr, int i, int j) {

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}